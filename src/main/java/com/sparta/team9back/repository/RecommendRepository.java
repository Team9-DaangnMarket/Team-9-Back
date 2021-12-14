package com.sparta.team9back.repository;

import com.sparta.team9back.model.Recommend;
import com.sparta.team9back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {
    List<Recommend> findAllByUser(User user);
}
