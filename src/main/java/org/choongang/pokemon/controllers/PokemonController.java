package org.choongang.pokemon.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.ListData;
import org.choongang.global.Pagination;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PathVariable;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.pokemon.PokemonSearch;
import org.choongang.pokemon.PokemonDetail;
import org.choongang.pokemon.exceptions.PokemonNotFoundException;
import org.choongang.pokemon.services.PokemonInfoService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonInfoService infoService;
    private final HttpServletRequest request;

    @GetMapping("/main")
    public String main(PokemonSearch search) {
        commonProcess();
        System.out.println("유입!");
        ListData<PokemonDetail> listData = infoService.getList(search);
        List<PokemonDetail> items = listData.getItems();
        Pagination pagination = listData.getPagination();

        request.setAttribute("items", items);
        request.setAttribute("pagination", pagination);

        return "main/main";
    }

    @GetMapping("/pokemon/{seq}")
    public String view(@PathVariable("seq") long seq) {
        commonProcess();

        PokemonDetail data = infoService.get(seq).orElseThrow(PokemonNotFoundException::new);
        System.out.println(data);
        request.setAttribute("data", data);

        return "main/view";
    }

    private void commonProcess() {
        request.setAttribute("addCss", new String[] {"pokemon/pokemon"});
    }
}