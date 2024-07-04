package org.choongang.pokemon.mapper;

import org.apache.ibatis.annotations.Param;
import org.choongang.pokemon.PokemonDetail;
import org.choongang.pokemon.PokemonDetail2;
import org.choongang.pokemon.PokemonSearch;

import java.util.List;

public interface PokemonMapper {
    int register(PokemonDetail params);
    PokemonDetail2 get(long seq);
    List<PokemonDetail> getList(PokemonSearch search);

     //포켓몬 랜덤 조회
   PokemonDetail getRandom();

    // 포켓몬 목록 총 갯수
    int getTotal(PokemonSearch search);

    List<PokemonDetail2> getMyPokemons(long userNo);
    int registerMyPokemon(@Param("userNo") long userNo, @Param("seq") long seq, @Param("nickName") String nickName);
    int deleteMyPokemon(@Param("userNo") long userNo, @Param("seq") long seq);
    int deleteAllMyPokemon(long userNo);
    List<Long> getMyPokemonSeqs(long userNo);
    int myPokemonExists(@Param("userNo") long userNo, @Param("seq") long seq);


}


