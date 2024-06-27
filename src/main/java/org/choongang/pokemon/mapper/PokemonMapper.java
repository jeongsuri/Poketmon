package org.choongang.pokemon.mapper;


import org.choongang.pokemon.PokemonDetail;
import org.choongang.pokemon.PokemonSearch;

import java.util.List;

public interface PokemonMapper {
    int register(PokemonDetail params);
    PokemonDetail get(long seq);
    List<PokemonDetail> getList(PokemonSearch search);
}
