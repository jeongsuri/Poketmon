package org.choongang.pokemon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Pokemon {
    private int id;
    private boolean is_default;
    private Sprite sprites;
    private List<Type> types;
    private int weight;

    @JsonIgnore
    private String rawData;

    @JsonIgnore
    private String name;

    @JsonIgnore
    private String flavor_text;
}
