package org.choongang.member.mapper;

import org.choongang.member.entities.Member;

public interface MemberMapper {
    Member get(String userId);
    int exists(String userId);
    int register(Member member);
    int modify(Member member);
    int adminModify(Member member);
}
