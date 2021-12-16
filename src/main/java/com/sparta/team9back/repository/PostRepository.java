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
    void upLikeCnt(Long id); // 자료형을 void라고 바꿔도 무방하지 않을까?

    @Modifying
    @Query("update Post a set a.postLikes = a.postLikes - 1 where a.postId = :id")
    void downLikeCnt(Long id);

    @Modifying
    @Query("update Post a set a.visitCount = a.visitCount + 1 where a.postId = :id")
    void upVisitCnt(Long id);
}