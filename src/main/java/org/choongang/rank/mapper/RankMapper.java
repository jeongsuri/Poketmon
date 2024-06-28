package org.choongang.rank.mapper;

import org.choongang.rank.entities.Rank;

import java.util.List;

public interface RankMapper {
    List<Rank> getRanking();
    Rank getUserRank(String userId);
}
