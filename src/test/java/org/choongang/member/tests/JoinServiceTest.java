package org.choongang.member.tests;


import com.github.javafaker.Faker;
import org.choongang.global.config.DBConn;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.services.JoinService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("회원가입 기능 테스트")
public class JoinServiceTest {

    private JoinService joinService;
    private MemberMapper memberMapper;

    @BeforeEach
    void init() {
        joinService = MemberServiceProvider_temp.getInstance().joinService();
        memberMapper = DBConn.getSession().getMapper(MemberMapper.class);
    }


    RequestJoin getData() {
        Faker faker = new Faker();

        RequestJoin form = new RequestJoin();
            form.setUserId(String.valueOf(faker.idNumber()));
            form.setPassword(faker.internet().password());
            form.setNickName(String.valueOf(faker.name()));

            form.setConfirmPassword(form.getPassword());

        return form;

    }

    @Test
    @DisplayName("임의로 랜덤하게 데이터 클래스에 값 넣어주기")
    void getDataTest() {
        Faker faker = new Faker();
        RequestJoin form = new RequestJoin();
            form.setUserId(faker.regexify("\\w{10}").toLowerCase());
            form.setPassword(faker.regexify("\\w{10}").toLowerCase());
            form.setNickName(String.valueOf(faker.name()));

            form.setConfirmPassword(form.getPassword());

            System.out.println(form);
    }


    @Test
    @DisplayName("회원가입 성공 시 예외 발생하지 않음")
    void successTest() {
        RequestJoin form = getData();
        assertDoesNotThrow(() -> {
            joinService.process(form);
        });

        // 가입된 아이디로 회원이 조회되는지 체크
        Member member = memberMapper.get(form.getUserId());
        assertEquals(form.getPassword(), member.getPassword());
    }

    @Test
    @DisplayName("필수 입력항목(아이디, 비밀번호, 비밀번호 확인, 닉네임) 검증, 검증 실패 시 예외 BadRequestException 발생")
    void requestFormValidatorTest() {
        assertAll(
                () -> requiredEachFieldTest("userId", true, "아이디"),
                () -> requiredEachFieldTest("userId", false, "아이디"),
                () -> requiredEachFieldTest("password", true, "비밀번호"),
                () -> requiredEachFieldTest("password", false, "비밀번호"),
                () -> requiredEachFieldTest("confirmPassword", true, "비밀번호를 확인"),
                () -> requiredEachFieldTest("confirmPassword", false, "비밀번호를 확인"),
                () -> requiredEachFieldTest("userName", true, "회원명"),
                () -> requiredEachFieldTest("userName", false, "회원명")
        );
    }

    void requiredEachFieldTest(String field, boolean isNull, String keyword) {
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {// BadRequestException.class라는 예외가 예상됨
            RequestJoin form = getData();
            if (field.equals("email")) { //
                form.setEmail(isNull?null:"    ");
            } else if (field.equals("password")) {
                form.setPassword(isNull?null:"    ");
            } else if (field.equals("confirmPassword")) {
                form.setConfirmPassword(isNull?null:"    ");
            } else if (field.equals("userName")) {
                form.setUserName(isNull?null:"     ");
            } else if (field.equals("termsAgree")) {
                form.setTermsAgree(false);
            }

            service.process(form); // 서비스 실행

        }, field + " 테스트"); // 반환값 : 발생한 예외객체

        String message = thrown.getMessage();
        assertTrue(message.contains(keyword), field + " 키워드 테스트");
}
