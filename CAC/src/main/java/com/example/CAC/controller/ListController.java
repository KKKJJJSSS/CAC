package com.example.CAC.controller;

import com.example.CAC.entity.Cac;
import com.example.CAC.entity.CacRepository;
import com.example.CAC.service.CacService;
import com.example.CAC.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequiredArgsConstructor
public class ListController {
    private final CacService cacService;
    private final KakaoService kakaoService;

    @GetMapping("/")
    public String list(HttpSession session, String keyword, Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Cac> paging = this.cacService.getList(keyword, page);

        if (keyword == null) {
            keyword = "";
        }

        List<Cac> cacList = cacService.getAvg(keyword);
        List<Integer> moneyList = cacList.stream().map(Cac::getMoney).collect(Collectors.toList());

        double averageMoney = calculateAverageMoney(moneyList);

        String formattedAverageMoney = String.format("%,d", ((int) averageMoney / 10000) * 10000);
        String formattedAverageMoneyWithSpace = formattedAverageMoney + "원";

        model.addAttribute("kakaoLogoutUrl", kakaoService.getKakaoLogout());
        model.addAttribute("totalElements", paging.getTotalElements());
        model.addAttribute("pageNumber", paging.getNumber());
        model.addAttribute("pageSize", paging.getSize());
        model.addAttribute("keyword", keyword);
        model.addAttribute("paging", paging);
        model.addAttribute("user_id", session.getAttribute("user_id"));
        model.addAttribute("averageMoney", formattedAverageMoneyWithSpace);

        return "index";
    }

    private double calculateAverageMoney(List<Integer> moneyList) {
        if (moneyList.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        int count = 0;
        for (int money : moneyList) {
            sum += money;
            count++;
        }

        return (double) sum / count;
    }
}
