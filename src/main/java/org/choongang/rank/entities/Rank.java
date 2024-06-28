package org.choongang.rank.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Rank {
    private int ranking;
    private String userId;
    private int pokemonCount;
}