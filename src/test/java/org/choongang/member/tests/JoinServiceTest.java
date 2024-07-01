package org.choongang.member.tests;


import com.github.javafaker.Faker;
import org.choongang.global.config.DBConn;
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
            form.setUserId(String.valueOf(faker.idNumber()));
            form.setPassword(faker.internet().password());
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

        Member member = memberMapper.get(form.getUserId());
        assertEquals(form.getPassword(), member.getPassword());
    }

}
