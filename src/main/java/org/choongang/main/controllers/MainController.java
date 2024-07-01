package org.choongang.main.controllers;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index() {
        return "redirect:/main";
    }
}
