package com.example.CAC.service;

import com.example.CAC.entity.Cac;
import com.example.CAC.repository.CacRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class CacService {
    private final CacRepository cacRepository;

    public Page<Cac> getList(String keyword, int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(page, 15, Sort.by(sorts));

        if (keyword == null) {
            return this.cacRepository.findAll(pageable);
        }

        return this.cacRepository.findByTitleContaining(keyword, pageable);
    }

    public List<Cac> getSearchList(String keyword) {
        return cacRepository.findByTitleContaining(keyword);
    }

    public Cac write(Cac cac){
        return cacRepository.save(cac);
    }

    public String boardDelete(Long id, HttpSession session) {

        String userId = getSessionId(session);

        Optional<Cac> cacOptional = cacRepository.findById(id);

        if (cacOptional.isPresent()) {
            Cac cac = cacOptional.get();
            String kakaoId = String.valueOf(cac.getKakao_id());

            if (kakaoId.equals(userId)) {
                cacRepository.deleteById(id);
                return "success";
            } else {
                return "fail";
            }
        } else {
            return "error";
        }
    }

    public String getSessionId(HttpSession session) {

        String userId = null;
        Object userIdObj = session.getAttribute("user_id");
        if (userIdObj != null) {
            userId = String.valueOf(userIdObj);
        }

        return userId;
    }
}
