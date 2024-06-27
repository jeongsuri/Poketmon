package org.choongang.pokemon;

import lombok.Builder;
import lombok.Data;
import org.choongang.pokemon.entities.Pokemon;

@Data
@Builder
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
