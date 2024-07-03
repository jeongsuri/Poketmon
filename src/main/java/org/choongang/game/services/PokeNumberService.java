package org.choongang.game.services;

import lombok.RequiredArgsConstructor;
import org.choongang.game.mapper.GameMapper;
import org.choongang.global.config.annotations.Service;
import org.choongang.member.MemberUtil;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PokeNumberService {
    private final GameMapper mapper;
    private final MemberUtil memberUtil;

    public long randomPokeNumber() {
        List<Integer> caughtPokemon = mapper.get((int)memberUtil.getMember().getUserNo());
        long randomNum = (new Random()).nextLong(1, 151);


        for (Integer i : caughtPokemon) {
            if ((long)i == randomNum) {
                randomNum = (new Random()).nextLong(1, 151);
            }
        }

        return randomNum;
    }
}
