package org.choongang.game.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.game.controllers.CatchPokemon;
import org.choongang.game.mapper.GameMapper;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;


@RequiredArgsConstructor
@Service
public class GameService {

    private final MemberUtil memberUtil;
    private final GameMapper mapper;

    public boolean process(long answerNumber) {
        HttpServletRequest request = BeanContainer.getInstance().getBean(HttpServletRequest.class);
        String nickName = request.getParameter("nickName");
        if (nickName == null)
            nickName = "X";

        Member member = memberUtil.getMember();
        if (!memberUtil.isLogin())
            return false;

        CatchPokemon catchPokemon = CatchPokemon.builder()
                .userNo(member.getUserNo())
                .pokemonNo(answerNumber)
                .nickName(nickName)
                .build();
        int result = mapper.registerNickName(catchPokemon);

        return result > 0;
    }
}
