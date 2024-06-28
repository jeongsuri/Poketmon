package org.choongang.mypage.controllers;


import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;


@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {


    @GetMapping
    public String mypage() {
        return "mypage/index";


    }
}


