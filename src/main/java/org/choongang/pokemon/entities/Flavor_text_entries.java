package org.choongang.pokemon.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Flavor_text_entries {
    private String flavor_text;
}
