package com.example.CAC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/new-post")
    public String post() {
        return "upload_page";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
