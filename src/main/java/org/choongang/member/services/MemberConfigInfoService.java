package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberDataMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberConfigInfoService {

    private final MemberDataMapper mapper;

    public Member getMember(String userId){
        return mapper.getMember(userId);
    }

    //회원리스트 조회
    public List<Member> getList(){

        return mapper.getList();
    }

    //회원삭제
    public int delete(String userId){
        return mapper.delete(userId);
    }

}
