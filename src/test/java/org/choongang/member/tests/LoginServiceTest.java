package org.choongang.member.tests;

import com.github.javafaker.Faker;

import org.choongang.global.exceptions.AlertException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로그인 기능 테스트")
public class LoginServiceTest {

    private LoginService loginService;
    private JoinService joinService;
    private Faker faker;
    private RequestLogin loginform;

//    @Mock
//    HttpServletRequest request;
//
//    @Mock
//    private HttpSession session;

    @BeforeEach // 로그인 시 회원가입때 쓰여진 가짜데이터와 동일한 가짜데이터 넣어주게끔 구현함
    void init() {
         joinService = MemberServiceProvider_temp.getInstance().joinService();

        faker = new Faker(Locale.ENGLISH);

        RequestJoin joinForm = getData();

        loginform = new RequestLogin();
        loginform.setUserId(joinForm.getUserId());
        loginform.setPassword(joinForm.getPassword());

        loginService = MemberServiceProvider_temp.getInstance().loginService();
        joinService.process(joinForm);
    }

    RequestJoin getData() {
        RequestJoin joinform = new RequestJoin();
        joinform.setUserId(faker.regexify("[a-zA-Z0-9]{10}").toLowerCase());
        joinform.setPassword(faker.regexify("[a-zA-Z0-9]{10}").toLowerCase());
        joinform.setNickName(faker.name().fullName() + System.currentTimeMillis());
        //joinform.setNickName(String.valueOf(faker.name())); // 유니크 무결성 제약조건에 걸림
        joinform.setConfirmPassword(joinform.getPassword());

        return joinform;

    }
        //setData();

        //given(request.getSession()).willReturn(session);
        // 모의객체로 만든 request.getSession() 요청세션이 들어오면 모의객체 세션을 반환

//    void setData() {
//        setParam("userId", form.getUserId());
//        setParam("password", form.getPassword());
//    }

//    void setParam(String name, String value) {
//        given(request.getParameter(name)).willReturn(value);
//        //스텁(가짜데이터)설정 : given(특정 메서드에 매개변수가 들어오면).willReturn(이러한 값을 반환하겠다)
//    }

    @Test
    @DisplayName("로그인 성공 시 예외가 발생하지 않음")
    void successTest() {
        assertDoesNotThrow(() -> {
            loginService.process(loginform);
        });
    }

    @Test
    @DisplayName("아이디 또는 비밀번호에 값을 넣지않거나 공백을 넣었을 시 AlertException 발생")
    void requiredFieldTest() {
        assertAll(
                () -> requiredEachFieldTest("userId", true, "아이디"),
                () -> requiredEachFieldTest("userId", false, "아이디"),
                () -> requiredEachFieldTest("password", true, "비밀번호"),
                () -> requiredEachFieldTest("password", false, "비밀번호")
        );
    }

    void requiredEachFieldTest(String name, boolean isNull, String message) {

        RequestJoin form = getData();
        loginform.setUserId(form.getUserId());
        loginform.setPassword(form.getPassword());
        AlertException thrown = assertThrows(AlertException.class, () -> {
            if(name.equals("userId")) {
                loginform.setUserId(isNull?null:"   ");
            } else if(name.equals("password")) {
               loginform.setPassword(isNull?null:"   ");
            }

            loginService.process(loginform);
        }, name + "테스트");




        String msg = thrown.getMessage();
        assertTrue(msg.contains(message), name + ", 키워드" + message + "테스트");
        assertEquals(400, thrown.getStatus()); // 에러 응답코드 맞는지 쳌
    }

    @Test
    @DisplayName("가입된 회원인지 검증, 가입된 회원이 아닐 시 AlertException 발생")
    void memberExistTest() {
        loginform.setUserId(getData().getUserId() + "123");
        AlertException thrown = assertThrows(AlertException.class, () -> {
            loginService.process(loginform);
        });

        String msg = thrown.getMessage();
        assertTrue(msg.contains("아이디 또는 비밀번호"));
        assertEquals(400, thrown.getStatus()); // 에러 응답코드 맞는지 쳌
    }

    @Test
    @DisplayName("가입된 회원이지만 비밀번호가 틀렸을 시 AlertException 발생")
    void passwordCheckTest() {
        loginform.setPassword(getData().getPassword() + "123");
        AlertException thrown = assertThrows(AlertException.class, () -> {
            loginService.process(loginform);
        });

        String msg = thrown.getMessage();
        assertTrue(msg.contains("아이디 또는 비밀번호가"));
        assertEquals(400, thrown.getStatus()); // 에러 응답코드 맞는지 쳌
    }
}


