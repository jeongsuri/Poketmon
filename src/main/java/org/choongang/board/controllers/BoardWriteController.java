package org.choongang.board.controllers;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board/write")
@RequiredArgsConstructor
public class BoardWriteController {
    private final HttpServletRequest request;

    //글쓰기 페이지
    @GetMapping()
    public String write() {
        String url = request.getRequestURI();
        request.setAttribute("addCss", List.of("write"));
        return "board/write";
    }
}
