package org.choongang.game.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.pokemon.PokemonDetail;
import org.choongang.pokemon.exceptions.PokemonNotFoundException;
import org.choongang.pokemon.services.PokemonInfoService;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final HttpServletRequest request;
    private final PokemonInfoService infoService;

    @GetMapping
    public String game() {
        request.setAttribute("addCss", List.of("game"));
        PokemonDetail data = infoService.get((new Random()).nextLong(1, 151)).orElseThrow(PokemonNotFoundException::new);

        request.setAttribute("data", data);

        return "game/game";
    }



    @GetMapping("/catchPokemon")
    public String Catch() {

        request.setAttribute("addCss", List.of("catch"));

        return "game/catchPokemon";
    }
}