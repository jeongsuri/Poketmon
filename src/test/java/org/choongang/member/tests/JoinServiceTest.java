package org.choongang.member.tests;

import org.choongang.global.config.DBConn;
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
        //mapper = DBConn.getSession().getMapper(MemberMapper.class)
    }

    @Test
    @DisplayName("회원가입 성공 시 예외 발생하지 않음")
    void successTest() {
        assertDoesNotThrow(() -> {

        });
    }

}
