package org.choongang.game.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.game.services.GameService;
import org.choongang.game.services.TypeColor;
import org.choongang.global.config.annotations.*;
import org.choongang.global.exceptions.AlertException;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.pokemon.PokemonDetail;
import org.choongang.pokemon.exceptions.PokemonNotFoundException;
import org.choongang.pokemon.services.PokemonInfoService;
import org.mindrot.jbcrypt.BCrypt;


import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController implements RequiredValidator {
    private final HttpServletRequest request;
    private final PokemonInfoService infoService;
    private final GameService gameService;
    private final TypeColor typecolor;

    @RequestMapping
    public String game(@RequestParam("pokemonName") String pokemonName, @RequestParam("seq") long seq, @RequestParam("image") String image) {
        long randomNum = (new Random()).nextLong(1, 151);

        if (seq > 0L && !pokemonName.isBlank()) {
            PokemonDetail detail = infoService.get(seq).orElse(null);

            if (pokemonName != null) {
                checkTrue(detail.getName().equals(pokemonName) ,  new AlertException("오답입니다.", HttpServletResponse.SC_BAD_REQUEST));
                if (detail.getName().equals(pokemonName)) {
                    request.setAttribute("addCss", List.of("catch"));


                    return "game/catchPokemon";
                }
            }
        }
        request.setAttribute("addCss", List.of("game"));

        PokemonDetail data = infoService.get(randomNum).orElseThrow(PokemonNotFoundException::new);

        request.setAttribute("data", data);
        String typeColor1 = typecolor.getTypeColor(data.getType1());
        String typeColor2 = typecolor.getTypeColor(data.getType2());

        request.setAttribute("typeColor1", typeColor1);
        request.setAttribute("typeColor2", typeColor2);

        return "game/game";
    }



    @PostMapping("/catch")
    public String CatchPs(@RequestParam("pokemonNo") long pokemonNo) {
        gameService.process(pokemonNo);

        String script = String.format("parent.location.replace('%s');", request.getContextPath() + "/mypage");
        request.setAttribute("script", script);
        return "commons/execute_script";
    }
}