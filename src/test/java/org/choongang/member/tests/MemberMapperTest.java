package org.choongang.member.tests;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.config.DBConn;
import org.choongang.member.constants.UserType;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberMapperTest {
    private SqlSession sqlSession;
    private MemberMapper memberMapper;

    @BeforeEach
    void init() {
        sqlSession = DBConn.getSession(false);
        memberMapper = sqlSession.getMapper(MemberMapper.class);
    }

    @Test
    @DisplayName("회원 등록")
    void registerTest() {
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        Member member = Member.builder()
                .userNo(1)
                .userId("test100100")
                .password("test100100")
                .userType(UserType.USER) // 자료형 USERTYPE인데 어떻게 바꾸징
                .nickName("test100100")
                .build();
        mapper.register(member);
    }

    @Test
    @DisplayName("회원 조회")
    void getTest() {
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        Member userId = mapper.get("test01010101");
        System.out.println(userId);

    }
}
