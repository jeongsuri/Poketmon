package org.choongang.rank.mapper;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.config.DBConn;
import org.choongang.rank.entities.Rank;
import org.junit.jupiter.api.*;

import java.util.List;

public class MapperTest {

    private RankMapper mapper;
    private SqlSession session;

    @BeforeEach
    void init() {
        session = DBConn.getSession(false);
        mapper = session.getMapper(RankMapper.class);
    }

    @Test
    @DisplayName("전체 랭킹 1-10위 조회 테스트")
    void getRankingTest() {
        List<Rank> ranks = mapper.getRanking();

        Assertions.assertNotNull(ranks);
        Assertions.assertFalse(ranks.isEmpty());
        Assertions.assertTrue(ranks.size() >= 10); // 최소 10개 이상의 결과가 있어야 함
        ranks.forEach(rank -> {
            System.out.println(rank.getUserId() + ": " + rank.getPokemonCount());
            Assertions.assertNotNull(rank.getUserId());
            Assertions.assertTrue(rank.getPokemonCount() >= 0); // 점수는 음수가 아니어야 함
        });
    }

    @Test
    @DisplayName("유저 아이디 랭킹 검색 조회 테스트")
    void getUserRankingTest() {
        String userId = "user01";

        Rank userRank = mapper.getUserRank(userId);

        Assertions.assertNotNull(userRank);
        Assertions.assertEquals(userId, userRank.getUserId());
        Assertions.assertTrue(userRank.getPokemonCount() >= 0); // 점수는 음수가 아니어야 함
        System.out.println("User Rank - UserId: " + userRank.getUserId() + ", Score: " + userRank.getPokemonCount());
    }
}
