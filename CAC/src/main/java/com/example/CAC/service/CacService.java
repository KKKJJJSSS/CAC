package com.example.CAC.service;

import com.example.CAC.entity.Cac;
import com.example.CAC.entity.CacRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CacService {
    private final CacRepository cacRepository;

    public Page<Cac> getList(String keyword, int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));

        if (keyword == null) {
            return this.cacRepository.findAll(pageable);
        }

        return this.cacRepository.findByTitleContaining(keyword, pageable);
    }
}
