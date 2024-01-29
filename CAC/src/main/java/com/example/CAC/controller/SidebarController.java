package com.example.CAC.controller;

import com.example.CAC.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class SidebarController {

    private final KakaoService kakaoService;

    @GetMapping("/sidebar")
    public ResponseEntity<?> getSidebarData(HttpSession session) {

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("user_id", session.getAttribute("user_id"));
        responseData.put("kakaoLogoutUrl", kakaoService.getKakaoLogout());

        return ResponseEntity.ok(responseData);
    }
}
