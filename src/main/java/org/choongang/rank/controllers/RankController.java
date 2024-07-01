package org.choongang.rank.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.*;
import org.choongang.rank.entities.Rank;
import org.choongang.rank.services.RankService;

import java.util.List;

@Controller
@RequestMapping("/rank")
@RequiredArgsConstructor
public class RankController {
    private final HttpServletRequest request;
    private final RankService rankService;

    @GetMapping
    public String rank() {
        List<Rank> rankingList = rankService.getRanking();

        request.setAttribute("rankingList", rankingList);
        request.setAttribute("addCss", List.of("rank"));

        return "rank/rank";
    }
    // /search?userId=user01
    @GetMapping("/search")
    public String search(@RequestParam("userId") String userId) {
        Rank userRank = rankService.getUserRank(userId);
        request.setAttribute("userRank", userRank);
        request.setAttribute("addCss", List.of("rank"));

        return "rank/search";
    }
}

