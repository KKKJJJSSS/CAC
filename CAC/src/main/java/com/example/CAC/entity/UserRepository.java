package com.example.CAC.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsernameAndPasswordContaining(String username, String password);
}
