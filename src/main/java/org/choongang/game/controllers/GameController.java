package org.choongang.game.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.pokemon.services.TranslateName;
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

    String answerName = "정답";
    String answerImage;
    long answerNumber;

    @GetMapping
    public String game() {
        String submitName = request.getParameter("pokemonName");
        if (answerName.equals(submitName)) {

            return "redirect:/game/catchPokemon";
        }
        request.setAttribute("addCss", List.of("game"));

        PokemonDetail data = infoService.get((new Random()).nextLong(1, 151)).orElseThrow(PokemonNotFoundException::new);
        answerName = data.getName();
        answerNumber = data.getSeq();
        answerImage = data.getFrontDefault();


        request.setAttribute("data", data);

            return "game/game";
    }



    @GetMapping("/catchPokemon")
    public String Catch() {
        request.setAttribute("addCss", List.of("catch"));

        request.setAttribute("answerName", answerName);
        request.setAttribute("answerImage", answerImage);

            return "game/catchPokemon";
    }
}