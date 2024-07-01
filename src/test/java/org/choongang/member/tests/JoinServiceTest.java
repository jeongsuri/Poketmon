package org.choongang.member.tests;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Service
@RequiredArgsConstructor
@DisplayName("회원가입 기능 테스트")
public class JoinServiceTest {

    private Member member;
    private MemberMapper memberMapper;

    @Test
    @DisplayName("회원가입 성공 시 예외 발생하지 않음")
    void successTest() {
        assertDoesNotThrow(() -> {

        });
    }

}
