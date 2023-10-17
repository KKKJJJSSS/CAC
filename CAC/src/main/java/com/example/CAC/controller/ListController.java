package com.example.CAC.controller;

import com.example.CAC.dto.MoneyDto;
import com.example.CAC.model.MoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListController {
    @Autowired
    public MoneyMapper moneyMapper;

    @GetMapping("/money_list")
    public String getMoneyList(Model model) {
        List<MoneyDto> moneyList = moneyMapper.getMoneyList();

        model.addAttribute("moneyList", moneyList);
        return "index";
    }
}
