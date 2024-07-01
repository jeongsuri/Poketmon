package org.choongang.game.mapper;


import org.choongang.game.controllers.CatchPokemon;

import java.util.List;

public interface GameMapper {
    int registerNickName(CatchPokemon catchPokemon);
    List<Integer> get(int userNo);
}


