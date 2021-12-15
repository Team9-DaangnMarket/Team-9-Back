package com.sparta.team9back.repository;

import com.sparta.team9back.model.Post;
import com.sparta.team9back.model.PostLike;
import com.sparta.team9back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    void deletePostLikeByPost(Post post);

    @Modifying
    @Query(value = "INSERT INTO postLike(post_id, user_id) VALUES(:postId, :userId)", nativeQuery = true)
    static void likes(Long postId, Long userId){

    }

    @Modifying
    @Query(value = "DELETE FROM postLike WHERE post_id = :postId AND user_id = :userId", nativeQuery = true)
    static void unLikes(Long postId, Long userId){
        // static 과 {} 없앤 상태였으나 commit용 임시변통
    }

    Boolean existsByUserAndPost(User user, Post post);
    List<PostLike> findAllByUser(User user);
    PostLike findByUserAndPost(User user, Post post);

}
