package org.choongang.member.controllers;

import lombok.Data;

@Data
public class RequestJoin {
    private String userId;
    private String password;
    private String confirmPassword;
    private String nickName;
}
