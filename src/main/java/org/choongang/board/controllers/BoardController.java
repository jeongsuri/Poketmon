package org.choongang.board.controllers;


import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    @RequestMapping("/boarding")
    public String boarding() {
        return "boarding";
    }
}