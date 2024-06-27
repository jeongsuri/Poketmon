package org.choongang.game.entities;

import lombok.Builder;
import lombok.Data;

import java.net.URL;

@Data
@Builder
public class PokemonData {
    private int seq;
    private String name;
    private int weight;
    private String type1;
    private String type2;
    private String flavorText;
    private String frontDefault;
}
