package org.choongang.game.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatchPokemon {
    long userNo;
    long pokemonNo;
    String nickName;
}
