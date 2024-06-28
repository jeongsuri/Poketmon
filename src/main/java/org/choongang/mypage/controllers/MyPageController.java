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


    /* @GetMapping
     public String mypage() {
          return "mypage/index"; */


          @GetMapping("/member/mypage")
          public String myPage(Long userId, Model model) {
               List<Pokemon> pokemons;
               model.addText("pokemons");
               return "mypage"; // mypage.jsp 또는 다른 View 이름으로 설정
          }

    @Component
    public class MemberUtil { //로그인 여부



        private boolean getMember() {
             return false;
        }
    }

    }


