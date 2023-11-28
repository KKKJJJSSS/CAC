package com.example.CAC.controller;

import com.example.CAC.entity.Cac;
import com.example.CAC.service.CacService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UploadController {
    private final CacService cacService;

    @PostMapping("/board")
    public RedirectView write(Cac cac) {
        cacService.write(cac);

        return new RedirectView("/");
    }
}
