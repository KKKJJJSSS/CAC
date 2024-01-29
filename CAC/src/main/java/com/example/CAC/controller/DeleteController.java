package com.example.CAC.controller;

import com.example.CAC.service.CacService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class DeleteController {
    private final CacService cacService;

    @PostMapping("/table/delete")
    public ResponseEntity<?> deleteTable(@RequestBody Map<String, Object> request, HttpSession session) {
        Long table_id = Long.valueOf(request.get("id").toString());

        String result = cacService.boardDelete(table_id, session);
        if (result.equals("success")) {
            return ResponseEntity.ok("삭제 되었습니다.");
        } else {
            return ResponseEntity.badRequest().body("권한이 없습니다.");
        }
    }
}
