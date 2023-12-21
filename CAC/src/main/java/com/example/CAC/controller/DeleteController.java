package com.example.CAC.controller;

import com.example.CAC.service.CacService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
@RequiredArgsConstructor
@Controller
public class DeleteController {
    private final CacService cacService;

    @GetMapping("/board/delete")
    public String boardDelete(Long id, HttpSession session, RedirectAttributes redirectAttributes) {
        String result = cacService.boardDelete(id, session);
        if (result.equals("success")) {
            redirectAttributes.addFlashAttribute("msg", "삭제 되었습니다.");
        } else {
            redirectAttributes.addFlashAttribute("msg", "권한이 없습니다.");
        }
        return "redirect:/";
    }
}
