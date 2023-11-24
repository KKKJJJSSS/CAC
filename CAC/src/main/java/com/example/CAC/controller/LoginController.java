package com.example.CAC.controller;

import com.example.CAC.entity.User;
import com.example.CAC.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/check/login")
    public String list(String username, String password) {
        List<User> content = loginService.checkLogin(username, password);

        if (content != null) {
            System.out.println("fail");
        } else {
            System.out.println("success");
        }

        return "upload_page";
    }
}