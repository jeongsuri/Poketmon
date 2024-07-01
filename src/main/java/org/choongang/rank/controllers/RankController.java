package org.choongang.rank.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.*;
import org.choongang.rank.entities.Rank;
import org.choongang.rank.mapper.RankMapper;

import java.util.List;

@Controller
@RequestMapping("/rank")
@RequiredArgsConstructor
public class RankController {
    private final HttpServletRequest request;
    private final RankMapper rankMapper;

    @GetMapping
    public String rank() {
        List<Rank> rankingList = rankMapper.getRanking();

        request.setAttribute("rankingList", rankingList);
        request.setAttribute("addCss", List.of("rank"));

        return "rank/rank";
    }

    @GetMapping("/search")
    public String search(@RequestParam("userId") String userId) {
        Rank userRank = rankMapper.getUserRank(userId);
        request.setAttribute("userRank", userRank);
        request.setAttribute("addCss", List.of("rank"));

        return "rank/search";
    }
}

