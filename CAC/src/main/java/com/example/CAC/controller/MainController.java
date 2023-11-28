package com.example.CAC.controller;

import com.example.CAC.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final KakaoService kakaoService;

    @GetMapping("/new-post")
    public String post(Model model, HttpSession session) {
        Object userId = session.getAttribute("user_id");

        if (userId == null) {
            return "redirect:/login";
        }

        model.addAttribute("user_id", session.getAttribute("user_id"));
        model.addAttribute("kakaoLogoutUrl", kakaoService.getKakaoLogout());
        return "upload_page";
    }
}
