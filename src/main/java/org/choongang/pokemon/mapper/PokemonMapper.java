package org.choongang.pokemon.mapper;

import org.choongang.pokemon.PokemonDetail;
import org.choongang.pokemon.PokemonSearch;

import java.util.List;

public interface PokemonMapper {
    int register(PokemonDetail params);
    PokemonDetail get(long seq);
    List<PokemonDetail> getList(PokemonSearch search);
    // 포켓몬 목록 총 갯수
    int getTotal(PokemonSearch search);
}


