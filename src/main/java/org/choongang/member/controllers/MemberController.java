package org.choongang.member.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.*;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinService joinService;
    private final LoginService loginService;

    // 회원 가입 양식
    @GetMapping("/join")
    public String join(HttpServletRequest request) {
        request.setAttribute("addCss", List.of("member/joinStyle"));

        return "member/join";
    }

    // 회원 가입 처리
    @PostMapping("/join")
    public String joinPs(RequestJoin form, HttpServletRequest request) {

        joinService.process(form);

        String url = request.getContextPath() + "/member/login";
        String script = String.format("parent.location.replace('%s');", url);

        request.setAttribute("script", script);

        return "commons/execute_script";
    }

    // 로그인 양식
    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        request.setAttribute("addCss", List.of("member/loginStyle"));

        return "member/login";
    }

    // 처음 사이트 접근 시 로그인 화면
    // 로그인 양식
    /*
    @GetMapping
    public String initLogin(HttpServletRequest request) {
        request.setAttribute("addCss", List.of("member/loginStyle"));

        return "member/login";
    }
    */

    // 로그인 처리
    @PostMapping("/login")
    public String loginPs(RequestLogin form, HttpServletRequest request) {

        loginService.process(form);

        String redirectUrl = form.getRedirectUrl();
        redirectUrl = redirectUrl == null || redirectUrl.isBlank() ? "/main" : redirectUrl;

        String script = String.format("parent.location.replace('%s');", request.getContextPath() + redirectUrl);

        request.setAttribute("script", script);

        return "commons/execute_script";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 비우기 : 로그 아웃

        return "redirect:/member/login"; // 페이지 이동 response.sendRedirect(...)
    }
}