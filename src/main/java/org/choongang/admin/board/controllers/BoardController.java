package org.choongang.admin.board.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/board")
public class BoardController {

    // 게시판 목록
    @GetMapping
    public String boardList() {
        return "admin/board/index";
    }

    // 게시판 등록
    @GetMapping("/register")
    public String register() {

        return "admin/board/register";
    }
}