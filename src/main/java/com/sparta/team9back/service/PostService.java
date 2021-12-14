package com.sparta.team9back.service;

import com.sparta.team9back.dto.PostRequestDto;
import com.sparta.team9back.dto.PostResponseDto;
import com.sparta.team9back.model.Post;
import com.sparta.team9back.model.User;
import com.sparta.team9back.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional // 이걸 잊지 않았나 하는 생각.
    public PostResponseDto createPost(PostRequestDto postRequestDto, User user) {

        Post post = Post.builder()
                .user(user)
                .goodsImg(postRequestDto.getGoodsImg())
                .title(postRequestDto.getTitle())
                .content(postRequestDto.getContent())
                .negoCheck(postRequestDto.getNegoCheck())
                .category(postRequestDto.getCategory())
                .price(postRequestDto.getPrice())
                .build();
        postRepository.save(post);

        return PostResponseDto.builder()
                .username(user.getUsername())
                .title(postRequestDto.getTitle())
                .content(postRequestDto.getContent())
                .category(postRequestDto.getCategory())
                .goodsImg(postRequestDto.getGoodsImg())
                .price(postRequestDto.getPrice())
                .negoCheck(postRequestDto.getNegoCheck())
                .build();
    }

    @Transactional
    public PostResponseDto showDetail(Long postId, User user) {

        Post post = postRepository.findById(postId).orElse(null);
        if (post == null) {
            throw new NullPointerException("해당 게시글 정보가 존재하지 않습니다.");
        }

        return PostResponseDto.builder()
                .username(user.getUsername())
                .title(post.getTitle())
                .content(post.getContent())
                .category(post.getCategory())
                .goodsImg(post.getGoodsImg())
                .price(post.getPrice())
                .negoCheck(post.getNegoCheck())
                .build();
    }

    @Transactional
    public void updatePost(Long postId, PostRequestDto postRequestDto, User user) {
        Post post = postRepository.findByUserAndPostId(user, postId).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        post.update(postRequestDto);
    }

    @Transactional
    public void deletePost(Long postId, User user) {
        Long checkId = postRepository.findByUser(user).orElse(null).getPostId();
        if(checkId.equals(postId))
            postRepository.deleteById(postId);
        // 댓글을 추가할 경우, 그리고 Post와 Comment entity 간에 cascade 설정을 해놓지 않은 경우
        // 댓글이 달린 게시글을 삭제할 때 Service에서 게시글에 달린 댓글을 전부 삭제하는 작업이 선행될 필요가 있음
    }
}
