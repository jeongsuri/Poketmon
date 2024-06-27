package org.choongang.rank.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rank {
    private long userNo;
    private String userId;
    private long pokemonNo;
    private String nickName;
}
