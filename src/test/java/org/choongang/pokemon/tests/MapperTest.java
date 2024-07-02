package org.choongang.pokemon.tests;

import org.choongang.global.config.DBConn;
import org.choongang.pokemon.PokemonDetail;
import org.choongang.pokemon.entities.Pokemon;
import org.choongang.pokemon.mapper.PokemonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class MapperTest {

    private PokemonMapper mapper;

    @BeforeEach
    void init(){
        mapper = DBConn.getSession().getMapper(PokemonMapper.class);
    }
    @Test
    void registerTest(){
        IntStream.rangeClosed(1,10).forEach(i->mapper.registerMyPokemon(101,i));
    }
    @Test
    void getMyPokemonsTest() {
        List<PokemonDetail> items = mapper.getMyPokemons(85L);
        items.forEach(System.out::println);
    }

    @Test
    void deleteMyPokemon(){
        int result = mapper.deleteMyPokemon(101L,67L);
        System.out.println(result);
    }

    @Test
    void deleteAllMyPokemon(){
        int result = mapper.deleteAllMyPokemon(101L);
        System.out.println(result);
    }
}
