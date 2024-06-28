package org.choongang.rank.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.rank.mapper.RankMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankService {
    private final RankMapper rankMapper;
}