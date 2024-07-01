package org.choongang.member.mapper;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.config.DBConn;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberDataMapperTest {

    private MemberDataMapper mapper;
    private SqlSession session;

    @BeforeEach
    void init() {
        session = DBConn.getSession(false);
        mapper = session.getMapper(MemberDataMapper.class);
    }


    @Test
    @DisplayName("회원 리스트 조회 성공시 - 성공")
    void getListTest() {
        List<Member> list = mapper.getList();
        list.forEach(System.out::println);
    }

}
