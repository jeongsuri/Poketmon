package org.choongang.board.controllers;


import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    //게시판 양식
    @RequestMapping("/boarding")
    public String boarding() {
        return "/board/boarding";
    }


}