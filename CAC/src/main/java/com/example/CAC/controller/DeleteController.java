package com.example.CAC.controller;

import com.example.CAC.service.CacService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
@RequiredArgsConstructor
@Controller
@RequestMapping("api")
public class DeleteController {
    private final CacService cacService;

    @PostMapping("/table/delete")
    public ResponseEntity<?> boardDelete(Long id, HttpSession session) {
        if (id == null) {
            id = 0L;
        }

        String result = cacService.boardDelete(id, session);
        if (result.equals("success")) {
            return ResponseEntity.ok("삭제 되었습니다.");
        } else {
            return ResponseEntity.badRequest().body("권한이 없습니다.");
        }
    }
}
