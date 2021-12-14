package com.sparta.team9back.repository;

import com.sparta.team9back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {




}


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 닉네임 존재 여부
    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}

