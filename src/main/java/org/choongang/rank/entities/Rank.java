package org.choongang.rank.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Rank {
    private int RANKING;
    private int POCKEMON_NO;
    private int USER_NO;
    private String USER_ID;
}