package org.choongang.pokemon.entities;

import lombok.Data;
import org.choongang.pokemon.entities.Pokemon;

@Data
public abstract class AbstractPokemonDetail {
    private Pokemon pokemon;
}