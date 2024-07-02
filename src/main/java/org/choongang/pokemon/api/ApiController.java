package org.choongang.pokemon.api;

import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PathVariable;
import org.choongang.pokemon.PokemonDetail;
import org.choongang.pokemon.services.PokemonInfoService;

public class ApiController {
    private final PokemonInfoService infoService;

    @GetMapping("/random")
    public PokemonDetail random() {
        PokemonDetail data = infoService.getRandom().orElseThrow(PokemonNotFoundException::new);


        return data;
    }

    @GetMapping("/get/{seq}")
    public PokemonDetail getOne(@PathVariable("seq") long seq) {
        PokemonDetail data = infoService.get(seq).orElseThrow(PokemonNotFoundException::new);

        return data;
    }
}
