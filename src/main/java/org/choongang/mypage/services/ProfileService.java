package org.choongang.mypage.services;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.member.MemberUtil;
import org.choongang.member.constants.UserType;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.mypage.controllers.RequestProfile;
import org.choongang.mypage.validators.ProfileUpdateValidator;
import org.mindrot.jbcrypt.BCrypt;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final MemberMapper mapper;
    private final ProfileUpdateValidator validator;
    private final MemberUtil memberUtil;

    public void update(RequestProfile form) {
        validator.check(form);

        String nickname = form.getNickName();
        String password = form.getPassword();
        long myPokemonSeq = form.getMyPokemonSeq();

        Member member = memberUtil.getMember(); // 로그인한 회원 정보

        member.setNickName(nickname);
        if (password != null && !password.isBlank()) {
            String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
            member.setPassword(hash);
        }

        member.setMyPokemonSeq(myPokemonSeq);

        // 회원 정보 수정 처리
        mapper.modify(member);

        // 세션 데이터 업데이트
        HttpSession session = BeanContainer.getInstance().getBean(HttpSession.class);
        Member _member = mapper.get(member.getUserId());
        session.setAttribute("member", _member);
    }

    //관리자 페이지 회원정보수정
    public void update(RequestProfile form, boolean isAdmin){
        validator.check(form, isAdmin);

        String userId = form.getUserId();
        String nickname = form.getNickName();
        String password = form.getPassword();
        String userType = form.getUserType();

        if (password != null && !password.isBlank()) {
            String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
            password = hash;
        }

        Member member = Member.builder()
                .userId(userId)
                .nickName(nickname)
                .password(password)
                .build();
        if(userType.equals("admin")){
            member.setUserType(UserType.ADMIN);
        }else {
            member.setUserType(UserType.USER);
        }

        mapper.adminModify(member);
    }
}