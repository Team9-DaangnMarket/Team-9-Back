package com.sparta.team9back.repository;

import com.sparta.team9back.model.Post;
import com.sparta.team9back.model.User;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository <Post, Long>{
    Optional<Post> findByUserAndPostId(User user, Long postId);
    List<Post> findAllByUser(User user);
    Optional<Post> findByUser(User user);
    Page<Post> findAllByOrderByPostIdDesc(Pageable pageable);
    Optional<Post> findByTitle(String title);
}