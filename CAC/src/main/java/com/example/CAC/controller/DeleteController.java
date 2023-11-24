package com.example.CAC.controller;

import com.example.CAC.service.CacService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class DeleteController {
    private final CacService cacService;
    @GetMapping("/board/delete")
    public String boardDelete(Long id){
        cacService.boardDelete(id);

        return "redirect:/";
    }
}
