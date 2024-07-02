package org.choongang.member.mapper;


import org.choongang.member.entities.Member;

import java.util.List;

public interface MemberDataMapper {
    Member getMember(String userId);
    List<Member> getList();
    int delete(String userId);
}
