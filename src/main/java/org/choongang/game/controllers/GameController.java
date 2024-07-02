package org.choongang.game.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.game.services.GameService;
import org.choongang.game.services.PokeNumberService;
import org.choongang.game.services.TypeColorService;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.global.config.annotations.RequestParam;
import org.choongang.pokemon.PokemonDetail;
import org.choongang.pokemon.exceptions.PokemonNotFoundException;
import org.choongang.pokemon.services.PokemonInfoService;

import java.util.List;

@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final PokemonInfoService infoService;
    private final GameService gameService;
    private final TypeColorService typeColorService;
    private final PokeNumberService pokeNumberService;

    @RequestMapping
    public String game(HttpServletRequest request, @RequestParam("pokemonName") String pokemonName, @RequestParam("seq") long seq, @RequestParam("image") String image) {
        long randomNum = pokeNumberService.randomPokeNumber();

        if (seq > 0L && !pokemonName.isBlank()) {
            PokemonDetail detail = infoService.get(seq).orElse(null);

                if (detail != null && detail.getName().equals(pokemonName)) {
                    request.setAttribute("addCss", List.of("catch"));

                    return "game/catchPokemon";
                } else {
                    request.setAttribute("errMessage", "아쉽지만... 오답입니다.");
                    randomNum = seq;
                }
        }
        request.setAttribute("addCss", List.of("game"));

        PokemonDetail data = infoService.get(randomNum).orElseThrow(PokemonNotFoundException::new);

        request.setAttribute("data", data);
        String typeColor1 = typeColorService.getTypeColor(data.getType1());
        String typeColor2 = typeColorService.getTypeColor(data.getType2());

        request.setAttribute("typeColor1", typeColor1);
        request.setAttribute("typeColor2", typeColor2);

        return "game/game";
    }



    @PostMapping("/catch")
    public String CatchPs(HttpServletRequest request, @RequestParam("pokemonNo") long pokemonNo, @RequestParam("pokemonName") String pokemonName) {
        gameService.process(pokemonNo, pokemonName);

        String script = String.format("parent.location.replace('%s');", request.getContextPath() + "/mypage");
        request.setAttribute("script", script);
        return "commons/execute_script";
    }
}