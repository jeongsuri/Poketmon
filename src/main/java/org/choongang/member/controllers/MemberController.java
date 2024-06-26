package org.choongang.member.controllers;


import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    // 회원 가입 양식
    @GetMapping("/join")
    public String join() {

        return "member/join";
    }

    // 회원 가입 처리
    @PostMapping("/join")
    public String joinPs() {



        return "member/join";
    }

    // 로그인 양식
    @GetMapping("/login")
    public String login() {

        return "member/login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String loginPs() {

        return "member/login";
    }
}