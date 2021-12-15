package com.sparta.team9back.repository;

import com.sparta.team9back.model.Post;
import com.sparta.team9back.model.PostLike;
import com.sparta.team9back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Boolean existsByUserAndPost(User user, Post post);
    //Boolean existByPost(Post post);
    //Recommend findByPost(Post post);
}
