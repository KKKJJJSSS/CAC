package com.example.CAC.controller;

import com.example.CAC.entity.Cac;
import com.example.CAC.service.CacService;
import com.example.CAC.entity.CacRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ListController {
    private final CacService cacService;

    public ListController(CacService cacService) {
        this.cacService = cacService;
    }

    @GetMapping("/")
    public String list(String keyword, Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Cac> paging = this.cacService.getList(keyword, page);

        if(keyword == null) {
            keyword = "";
        }

        model.addAttribute("keyword", keyword);
        model.addAttribute("paging", paging);

        return "index";
    }
}
