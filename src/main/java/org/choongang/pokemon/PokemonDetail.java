package org.choongang.pokemon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.pokemon.entities.AbstractPokemonDetail;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class PokemonDetail extends AbstractPokemonDetail {
    private long seq;
    private long rowNum;
    private String name;
    private int weight;
    private String type1;
    private String type2;
    private String flavorText;
    private String frontDefault;
    private String rawData;
}

