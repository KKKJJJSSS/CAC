package com.example.CAC.controller;

import com.example.CAC.entity.Cac;
import com.example.CAC.service.CacService;
import com.example.CAC.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ListController {
    private final CacService cacService;
    private final KakaoService kakaoService;

    @GetMapping("/table")
    public ResponseEntity<?> getTableData(@RequestParam(required = false) String keyword, @RequestParam(defaultValue = "0") int page) {
        Page<Cac> paging = cacService.getList(keyword, page);
        List<Cac> searchList = cacService.getSearchList(keyword);
        List<Integer> moneyList = searchList.stream().map(Cac::getMoney).collect(Collectors.toList());

        double averageMoney = calculateAverageMoney(moneyList);

        String formattedAverageMoney = String.format("%,d", ((int) averageMoney / 10000) * 10000);
        String formattedAverageMoneyWithSpace = formattedAverageMoney + "원";

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("averageMoney", formattedAverageMoneyWithSpace);
        responseData.put("paging", paging);
        responseData.put("totalElements", paging.getTotalElements());
        responseData.put("totalPages", paging.getTotalPages());
        responseData.put("pageNumber", paging.getNumber());
        responseData.put("pageSize", paging.getSize());

        return ResponseEntity.ok(responseData);
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

