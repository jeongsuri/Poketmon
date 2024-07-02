package org.choongang.member.tests;


import com.github.javafaker.Faker;
import org.choongang.global.config.DBConn;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.global.exceptions.AlertException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.services.JoinService;
import org.choongang.member.validators.JoinValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("회원가입 기능 테스트")
public class JoinServiceTest {

    private JoinService joinService;
    private BeanContainer beanContainer;
    private MemberMapper memberMapper;
    private JoinValidator joinValidator;

    @BeforeEach
    void init() {
        beanContainer = BeanContainer.getInstance();

        beanContainer.addBean("memberMapper", DBConn.getSession().getMapper(MemberMapper.class));
        memberMapper = (MemberMapper) beanContainer.getBeans().get("memberMapper");

        beanContainer.addBean("joinValidator", new JoinValidator(memberMapper));
        joinValidator = (JoinValidator) beanContainer.getBeans().get("joinValidator");

        beanContainer.addBean("joinService", new JoinService(joinValidator, memberMapper));
        joinService = (JoinService) beanContainer.getBeans().get("joinService");
    }


    RequestJoin getData() {
        Faker faker = new Faker(Locale.ENGLISH);

        RequestJoin form = new RequestJoin();
            form.setUserId(faker.regexify("[a-zA-Z0-9]{10}").toLowerCase());
            form.setPassword(faker.regexify("[a-zA-Z0-9]{10}").toLowerCase());
            form.setNickName(String.valueOf(faker.name()));

            form.setConfirmPassword(form.getPassword());

        return form;

    }

    @Test
    @DisplayName("임의로 랜덤하게 데이터 클래스에 값 넣어주기")
    void getDataTest() {
        Faker faker = new Faker();
        RequestJoin form = new RequestJoin();
            form.setUserId(faker.regexify("[a-zA-Z0-9]{10}").toLowerCase());
            form.setPassword(faker.regexify("[a-zA-Z0-9]{10}").toLowerCase());
            form.setNickName(String.valueOf(faker.name()));
            form.setConfirmPassword(form.getPassword());

    }


    @Test
    @DisplayName("회원가입 성공 시 예외 발생하지 않음")
    void successTest() {
        RequestJoin form = getData();
        assertDoesNotThrow(() -> {
            joinService.process(form);
        });

//         가입된 아이디로 회원이 조회되는지 체크
        Member member = memberMapper.get(form.getUserId());
        assertEquals(form.getUserId(), member.getUserId());
    }

    @Test // 흠...배드 리퀘스트 익셉션이 발생되는건뎅...
    @DisplayName("필수 입력항목(아이디, 비밀번호, 비밀번호 확인, 닉네임) 검증, 검증 실패 시 예외 AlertException 발생")
    void requestFormValidatorTest() {
        assertAll(
                () -> requiredEachFieldTest("userId", true, "아이디"),
                () -> requiredEachFieldTest("userId", false, "아이디"),
                () -> requiredEachFieldTest("password", true, "비밀번호"),
                () -> requiredEachFieldTest("password", false, "비밀번호"),
                () -> requiredEachFieldTest("confirmPassword", true, "비밀번호를 확인"),
                () -> requiredEachFieldTest("confirmPassword", false, "비밀번호를 확인"),
                () -> requiredEachFieldTest("nickName", true, "닉네임"),
                () -> requiredEachFieldTest("nickName", false, "닉네임")
        );
    }

    void requiredEachFieldTest(String field, boolean isNull, String keyword) {
        AlertException thrown = assertThrows(AlertException.class,() -> { // 반환값 : 발생한 예외객체
            RequestJoin form = getData();
            if (field.equals("userId")) {
                form.setUserId(isNull?null:"    ");
            } else if (field.equals("password")) {
                form.setPassword(isNull?null:"    ");
            } else if (field.equals("confirmPassword")) {
                form.setConfirmPassword(isNull?null:"    ");
            } else if (field.equals("nickName")) {
                form.setNickName(isNull?null:"     ");
            }

            joinService.process(form);

        }, field + " 테스트");

        String message = thrown.getMessage();
        assertTrue(message.contains(keyword), field + " 키워드 테스트");
        assertEquals(400, thrown.getStatus()); // 응답코드 맞는지 쳌
    }

    @Test
    @DisplayName("비밀번화와 확인이 일치하지 않으면 AllertException 발생")
    void passwordMismatchTest() {
        AlertException thrown = assertThrows(AlertException.class, () -> {
            RequestJoin form = getData();
            form.setConfirmPassword(form.getPassword() + "123");
            joinService.process(form);
        });

        String message = thrown.getMessage();

        System.out.println(message);
        assertTrue(message.contains("비밀번호가 일치")); // 에러메세지 맞게 뜨는지 쳌
        assertEquals(400, thrown.getStatus()); // 에러 응답코드 맞는지 쳌
    }

    @Test
    @DisplayName("아이디가 영문자 + 숫자 8~20자로 이루어져 있지 않으면 AllertException 발생")
    void userIdTest() {
        AlertException thrown = assertThrows(AlertException.class, () -> {
            RequestJoin form = getData();
            form.setUserId("123");
            joinService.process(form);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("아이디 형식이"));
        assertEquals(400, thrown.getStatus()); // 에러 응답코드 맞는지 쳌
    }

    @Test
    @DisplayName("비밀번호가 영문자 + 숫자 8~20자로 이루어져 있지 않으면 AllertException 발생")
    void passwordTest() {
        AlertException thrown = assertThrows(AlertException.class, () -> {
            Faker faker = new Faker();
            RequestJoin form = getData();

            form.setPassword(faker.regexify("\\w{3}").toLowerCase());
            form.setConfirmPassword(form.getPassword());
            System.out.println(form);
            joinService.process(form);
        });

        String message = thrown.getMessage();
        System.out.println(message);
        assertTrue(message.contains("비밀번호"));
        assertEquals(400, thrown.getStatus()); // 에러 응답코드 맞는지 쳌
    }

    @Test
    @DisplayName("이미 가입된 아이디인 경우 AlertException 발생")
    void userIdDoubleTest() {
        AlertException thrown = assertThrows(AlertException.class, () -> {
            RequestJoin form = getData();
            form.setUserId("test200200");
            form.setUserId("test200200");
            joinService.process(form);
        });
        String message = thrown.getMessage();
        assertTrue(message.contains("이미 가입된"));
        assertEquals(400, thrown.getStatus()); // 에러 응답코드 맞는지 쳌
    }
}