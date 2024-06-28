package org.choongang.mypage.controllers;


import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.entities.Member;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.LoginValidator;
import org.choongang.pokemon.entities.Pokemon;

import java.util.List;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {


    @GetMapping
    public String mypage() {
        return "mypage/index";


    }
}


