package com.sparta.team9back.service;

import com.sparta.team9back.model.Post;
import com.sparta.team9back.model.User;
import com.sparta.team9back.repository.PostRepository;
import com.sparta.team9back.repository.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostLikeService {
    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;

    //    @Transactional
//    public void onRecommend(User user, Long postId){
//        Post post = postRepository.findByPostId(postId).orElseThrow(null);
//
//        if(recommendRepository.existByPost(post)) {
//            Recommend recommend = Recommend.builder()
//                    .user(user)
//                    .post(post)
//                    .build();
//
//            recommendRepository.save(recommend);
//        }
//        else{
//            Recommend recommend = recommendRepository.findByPost(post);
//
//        }
//    }
//
//    @Transactional
//    public void offRecommend(User user,Long postId){
//        Post post = postRepository.findByPostId(postId).orElseThrow(null);
//
//        Recommend recommend = Recommend.builder()
//                .user(user)
//                .post(post)
//                .build();
//
//        recommendRepository.deleteById();
    @Transactional
    public void onLike(User user, Long postId){
        Long userId = user.getId();

    }
}