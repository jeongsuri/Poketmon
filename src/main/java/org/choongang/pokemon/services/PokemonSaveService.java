package org.choongang.pokemon.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.pokemon.PokemonDetail;
import org.choongang.pokemon.entities.Pokemon;
import org.choongang.pokemon.mapper.PokemonMapper;

@Service
@RequiredArgsConstructor
public class PokemonSaveService {
    private final PokemonMapper mapper;

    public boolean save(Pokemon data) {
        TranslateName translateName = new TranslateName();

        String type2 = "X";

        if (data.getTypes().size() > 1 && data.getTypes().get(1) != null) {
            type2 = data.getTypes().get(1).getType().getName();
        }

        PokemonDetail detail = PokemonDetail.builder()
                .seq(data.getId())
                .name(data.getName())
                .weight(data.getWeight())
                .type1(translateName.koreanName(data.getTypes().get(0).getType().getName()))
                .type2( translateName.koreanName(type2))
                .flavorText(data.getFlavor_text())
                .frontDefault(data.getSprites().getOther().getOfficial_artwork().getFront_default())
                .rawData(data.getRawData())
                .build();




        int result = mapper.register(detail);
        return result > 0;
    }
}
