package org.choongang.rank.mapper;

import org.choongang.global.config.DBConn;
import org.choongang.rank.entities.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapperTest {

    @Test
    void test1() {
        RankMapper mapper = DBConn.getSession().getMapper(RankMapper.class);
        List<Rank> ranks = mapper.getRanking();
        ranks.forEach(System.out::println);
    }
}
