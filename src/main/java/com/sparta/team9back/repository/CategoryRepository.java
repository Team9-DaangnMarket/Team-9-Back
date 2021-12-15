package com.sparta.team9back.repository;

import com.sparta.team9back.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByCategoryId(Category category);
}
