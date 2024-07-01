package org.choongang.member.mapper;


import org.choongang.member.entities.Member;

import java.util.List;

public interface MemberDataMapper {
    List<Member> getList();
    int delete(String userId);
}
