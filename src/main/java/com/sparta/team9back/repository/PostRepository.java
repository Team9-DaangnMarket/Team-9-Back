package com.sparta.team9back.repository;

import com.sparta.team9back.model.Post;
import com.sparta.team9back.model.User;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository <Post, Long>{
    Optional<Post> findByUserAndPostId(User user, Long postId);
    List<Post> findAllByUserOrderByPostIdDesc(User user);
    Page<Post> findAllByOrderByPostIdDesc(Pageable pageable);
    Optional<Post> findByPostId(Long postId);

    @Modifying
    @Query("update Post a set a.postLikes = a.postLikes + 1 where a.postId = :id")
    int upLikeCnt(Long id);

    @Modifying
    @Query("update Post a set a.postLikes = a.postLikes - 1 where a.postId = :id")
    int downLikeCnt(Long id);
}

