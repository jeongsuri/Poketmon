package org.choongang.rank.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rank")
@RequiredArgsConstructor
public class RankController {
    private final HttpServletRequest request;

    @GetMapping
    public String ranking() {
        String url = request.getRequestURI();
        request.setAttribute("addCss", List.of("rank"));

        return "rank/ranking";
    }
}
