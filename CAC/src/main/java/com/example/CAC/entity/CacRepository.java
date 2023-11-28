package com.example.CAC.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CacRepository extends JpaRepository<Cac, Long> {
    Page<Cac> findByTitleContaining(String keyword, Pageable pageable);
    List<Cac> findByTitleContaining(String keyword);
    Page<Cac> findAll(Pageable pageable);
}
