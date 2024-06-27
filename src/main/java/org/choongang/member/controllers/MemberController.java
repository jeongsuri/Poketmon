package org.choongang.member.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.*;

import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    // 회원 가입 양식
    @GetMapping("/join")
    public String join(HttpServletRequest request) {
        request.setAttribute("addCss", List.of("member/joinStyle"));
        return "member/join";
    }

    // 회원 가입 처리
    @PostMapping("/join")
    public String joinPs() {



        return "member/join";
    }

    // 로그인 양식
    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        request.setAttribute("addCss", List.of("member/loginStyle"));

        return "member/login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String loginPs() {

        return "member/login";
    }
}