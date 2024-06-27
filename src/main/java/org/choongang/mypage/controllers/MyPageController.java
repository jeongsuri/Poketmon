package org.choongang.mypage.controllers;


import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {



     public String mypage() {
          return "mypage";
     }
}


