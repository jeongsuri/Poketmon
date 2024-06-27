package org.choongang.pokemon.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpriteOther {
    @JsonAlias("official-artwork")
    private SpriteImage official_artwork;
}
