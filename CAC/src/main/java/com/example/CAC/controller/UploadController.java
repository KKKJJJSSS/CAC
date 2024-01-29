package com.example.CAC.controller;

import com.example.CAC.entity.Cac;
import com.example.CAC.service.CacService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UploadController {
    private final CacService cacService;

    @PostMapping("/new-table")
    public ResponseEntity<?> write(Cac cac) {
        cacService.write(cac);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/id-check")
    public ResponseEntity<?> getSessionId(HttpSession session) {
        String sessionId = cacService.getSessionId(session);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("kakao_id", sessionId);

        return ResponseEntity.ok(responseData);
    }
}
