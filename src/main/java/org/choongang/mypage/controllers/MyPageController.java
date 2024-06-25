package org.choongang.mypage.controllers;


import lombok.RequiredArgsConstructor;
import org.choongang.game.controllers.GameController;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.controllers.MemberController;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController extends GameController {



}