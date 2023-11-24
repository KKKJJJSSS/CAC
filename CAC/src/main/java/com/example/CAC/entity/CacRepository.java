package com.example.CAC.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CacRepository extends JpaRepository<Cac, Long> {
    Page<Cac> findByTitleContaining(String keyword, Pageable pageable);
    Page<Cac> findAll(Pageable pageable);
}
