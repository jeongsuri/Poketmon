package org.choongang.member.controllers;

import lombok.Data;

@Data
public class RequestLogin {
    private String userId;
    private String password;
    private String redirectUrl;
}
