package org.choongang.mypage.services;

import org.choongang.global.config.AppConfig;
import org.choongang.mypage.mapper.MyPageMapper;

public class MyPokemonService {

    private final MyPageMapper myPageMapper;

    // 포켓몬 API URL
    private String apiUrl = AppConfig.get("pokemon.api.url");

    public MyPokemonService(MyPageMapper myPageMapper) {
        this.myPageMapper = myPageMapper;


    }
}
