package org.choongang.mypage.controllers;

import lombok.Data;

@Data
public class RequestProfile {
    private String userId;
    private String nickName;
    private String password;
    private String confirmPassword;
    private String userType;
    private long myPokemonSeq;
}