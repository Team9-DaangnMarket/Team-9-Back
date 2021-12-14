package com.sparta.team9back.controller;

import com.sparta.team9back.dto.PostRequestDto;
import com.sparta.team9back.dto.PostResponseDto;
import com.sparta.team9back.security.UserDetailsImpl;
import com.sparta.team9back.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    // 게시글 작성(좋아요 미구현)
    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return postService.createPost(postRequestDto, userDetails.getUser());
    }

    // 상세 게시글 보기(좋아요 미구현)
    @GetMapping("/posts/{postId}")
    public PostResponseDto showDetail(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        return postService.showDetail(postId, userDetails.getUser());
    }

    // 게시글 수정(좋아요 미구현)
    @PutMapping("/posts/{postId}")
    public void updatePost(@PathVariable Long postId, @RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postService.updatePost(postId, postRequestDto, userDetails.getUser());
    }

    // 게시글 삭제(댓글 추가 구현 경우 수정할 필요성 있음)
    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        postService.deletePost(postId, userDetails.getUser());
    }

}
