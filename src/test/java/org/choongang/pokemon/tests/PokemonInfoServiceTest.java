package org.choongang.pokemon.tests;

import org.choongang.global.config.DBConn;
import org.choongang.global.services.ApiRequestService;
import org.choongang.global.services.ObjectMapperService;

import org.choongang.pokemon.PokemonDetail;
import org.choongang.pokemon.PokemonSearch;
import org.choongang.pokemon.entities.Item;
import org.choongang.pokemon.mapper.PokemonMapper;
import org.choongang.pokemon.services.PokemonInfoService;
import org.choongang.pokemon.services.PokemonSaveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("포켓몬 조회 서비스 테스트")
public class PokemonInfoServiceTest {

    private PokemonInfoService service;

    @BeforeEach
    void init() {
        PokemonMapper mapper = DBConn.getSession().getMapper(PokemonMapper.class);
        PokemonSaveService saveService = new PokemonSaveService(mapper);
        service = new PokemonInfoService(new ApiRequestService(), new ObjectMapperService(), saveService, mapper);
    }

    @Test
    @DisplayName("포켓몬 API V2에서 지원하는 API 요청 목록 조회 테스트")
    void getApiListTest() {
        assertDoesNotThrow(() -> {
            Map<String, String> items = service.getApiAll();
            System.out.println(items);
        });
    }

    @Test
    @DisplayName("포켓몬 목록 API 조회 테스트")
    void getListTest() {
        assertDoesNotThrow(() -> {
            PokemonSearch search = new PokemonSearch();
            search.setPage(1);
            search.setLimit(20);
            List<Item> items = service.getApiList(search);
            System.out.println(items);
        });
    }

    @Test
    @DisplayName("포켓몬 개별 조회 및 업데이트 테스트")
    void getTest() {
        assertDoesNotThrow(() -> {
            service.update(1);
        });
    }

    @Test
    @DisplayName("포켓몬 데이터 일괄 업데이트 테스트")
    void updateAllTest() {
        service.updateAll();
    }

    @Test
    @DisplayName("getList 메서드 테스트")
    void getListDbTest() {
        PokemonSearch search = new PokemonSearch();
        search.setPage(1);
        search.setLimit(5);

        service.getList(search);
    }

    @Test
    @DisplayName("get 메서드 테스트")
    void getDbTest() {
        PokemonDetail data = service.get(1L).orElse(null);
        System.out.println(data);

    }
}
