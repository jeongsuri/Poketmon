package org.choongang.game.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final HttpServletRequest request;

    @GetMapping
    public String game() {
        String uri = request.getRequestURI();
        System.out.println(uri);

        request.setAttribute("addCss", List.of("game"));

        return "game/game";
    }
}