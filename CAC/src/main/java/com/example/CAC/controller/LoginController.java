package com.example.CAC.controller;

import com.example.CAC.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class LoginController {

    private final KakaoService kakaoService;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(Model model, HttpSession session) {
        model.addAttribute("kakaoUrl", kakaoService.getKakaoLogin());
        model.addAttribute("kakaoLogoutUrl", kakaoService.getKakaoLogout());
        model.addAttribute("user_id", session.getAttribute("user_id"));

        return "login";
    }
}