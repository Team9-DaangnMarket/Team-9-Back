package com.sparta.team9back.repository;

import com.sparta.team9back.model.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {
}
