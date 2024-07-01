package org.choongang.mypage;

import lombok.Data;
import org.choongang.pokemon.entities.Pokemon;

@Data
public abstract class AbstractPokemonDetail {
    private Pokemon pokemon;
}
