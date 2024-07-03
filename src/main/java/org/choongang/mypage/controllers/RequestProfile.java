package org.choongang.mypage.controllers;

import lombok.Data;

@Data
public class RequestProfile {
    private String nickName;
    private String password;
    private String confirmPassword;
    private long myPokemonSeq;
}