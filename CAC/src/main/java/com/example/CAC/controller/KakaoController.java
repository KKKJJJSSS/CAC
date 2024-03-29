package com.example.CAC.controller;

import com.example.CAC.dto.KakaoDTO;
import com.example.CAC.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class KakaoController {

    private final KakaoService kakaoService;

    @GetMapping("/kakao/callback")
    public ResponseEntity<?> callback(HttpServletRequest request, HttpSession session) throws Exception {
        KakaoDTO kakaoInfo = kakaoService.getKakaoInfo(request.getParameter("code"));
        Long user_id = kakaoInfo.getId();
        session.setAttribute("user_id", user_id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/kakao/reset-session")
    public ResponseEntity<?> resetSession(HttpSession session) {
        session.invalidate();

        return ResponseEntity.ok().build();
    }
}