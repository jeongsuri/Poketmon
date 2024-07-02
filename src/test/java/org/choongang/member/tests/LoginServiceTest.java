package org.choongang.member.tests;

import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.BDDMockito.given;

@DisplayName("로그인 기능 테스트")
public class LoginServiceTest {

    private LoginService loginService;
    private JoinService joinService;
    private Faker faker;
    private RequestJoin form;
    private SqlSession dbSession;


//    @Mock
//    HttpServletRequest request;
//
//    @Mock
//    private HttpSession session;

    @BeforeEach
    void init() {
         loginService = MemberServiceProvider_temp.getInstance().loginService();
         joinService = MemberServiceProvider_temp.getInstance().joinService();
         dbSession = MemberServiceProvider_temp.getInstance().getSession();
        faker = new Faker();

         form = new RequestJoin();
        form.setUserId(faker.regexify("[a-zA-Z0-9]{10}").toLowerCase());
        form.setPassword(faker.regexify("[a-zA-Z0-9]{10}").toLowerCase());
        form.setNickName(String.valueOf(faker.name()));

        form.setConfirmPassword(form.getPassword());

        joinService.process(form);


        //setData();

        //given(request.getSession()).willReturn(session);
        // 모의객체로 만든 request.getSession() 요청세션이 들어오면 모의객체 세션을 반환
    }
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
            loginService.process(new RequestLogin());
        });
    }
}
