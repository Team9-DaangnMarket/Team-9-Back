package com.sparta.team9back.service;

import com.sparta.team9back.model.User;
import com.sparta.team9back.repository.PostRepository;
import com.sparta.team9back.repository.PostLikeRepository;
import com.sparta.team9back.repository.UserRepository;
import com.sparta.team9back.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostLikeService {
    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

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
    public void onLike(UserDetailsImpl userDetails, Long postId){
        if (userDetails == null)
            throw new IllegalArgumentException("회원가입 후 이용해주세요");
        Optional<User> user = userRepository.findById(userDetails.getUser().getId());
        Long userId = user.get().getId();
        PostLikeRepository.likes(postId, userId);
    }

    @Transactional
    public void unLike(UserDetailsImpl userDetails, Long postId) {
        if (userDetails == null)
            throw new IllegalArgumentException("회원가입 후 이용해주세요");
        Optional<User> user = userRepository.findById(userDetails.getUser().getId());
        Long userId = user.get().getId();
        PostLikeRepository.unLikes(postId, userId);
    }
}