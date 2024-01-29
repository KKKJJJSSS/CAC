package com.example.CAC.controller;

import com.example.CAC.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class LoginController {

    private final KakaoService kakaoService;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public ResponseEntity<?> login() {

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("kakaoUrl", kakaoService.getKakaoLogin());

        return ResponseEntity.ok(responseData);
    }
}