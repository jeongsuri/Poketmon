package org.choongang.game.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.game.controllers.CatchPokemon;
import org.choongang.game.mapper.GameMapper;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;


@RequiredArgsConstructor
@Service
public class GameService {
    private final GameMapper mapper;

    public void process(long answerNumber, String nickName) {
        HttpServletRequest request = BeanContainer.getInstance().getBean(HttpServletRequest.class);

        CatchPokemon catchPokemon = CatchPokemon.builder()
                .userNo(1)
                .pokemonNo(answerNumber)
                .nickName(nickName)
                .build();
        System.out.println(catchPokemon);
        mapper.registerNickName(catchPokemon);
    }
}
