

package com.sparta.team9back.service;

import com.sparta.team9back.model.Post;
import com.sparta.team9back.model.PostLike;
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

    @Transactional
    public void clickPostLike(User user, Long postId){
        Post post = postRepository.findByPostId(postId).orElseThrow(null);

        PostLike existLike = postLikeRepository.findByUserAndPost(user, post);
        if(postLikeRepository.existsByUserAndPost(user, post)) {     //해당 글에 좋아요 누른 상태 체크
            postLikeRepository.deleteById(existLike.getPostLikeId());   //postlike id 삭제
            postRepository.downLikeCnt(postId);
        }
        else{
            PostLike postLike = PostLike.builder()
                    .post(post)
                    .user(user)
                    .build();
            postLikeRepository.save(postLike);
            postRepository.upLikeCnt(postId);
        }
        postRepository.save(post);
    }

}