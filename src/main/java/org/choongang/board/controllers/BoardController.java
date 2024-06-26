package org.choongang.board.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final HttpServletRequest request;

    //게시판 양식
    @RequestMapping()
    public String boarding() {
        String url = request.getRequestURI();
        request.setAttribute("addCss", List.of("board"));
        return "board/boarding";
    }


}