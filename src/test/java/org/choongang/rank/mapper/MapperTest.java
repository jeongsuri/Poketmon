package org.choongang.rank.mapper;

import org.choongang.global.config.DBConn;
import org.choongang.rank.entities.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapperTest {

    @Test
    @DisplayName("전체 랭킹 1-10위 조회 테스트")
    void getRankingTest() {
        RankMapper mapper = DBConn.getSession().getMapper(RankMapper.class);
        List<Rank> ranks = mapper.getRanking();
        ranks.forEach(System.out::println);
    }

    @Test
    @DisplayName("유저 아이디 랭킹 검색 조회 테스트")
    void getUserRankingTest() {
        
    }
}
