package com.sparta.team9back.controller;

import com.sparta.team9back.model.User;
import com.sparta.team9back.security.UserDetailsImpl;
import com.sparta.team9back.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostLikeController {

    private final PostLikeService postLikeService;

    @PostMapping("/postLike/{postId}")
    public void registLike(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postId) {
        postLikeService.onLike(userDetails, postId);
    }

    @DeleteMapping("/postLike/{postId}")
    public void unLike(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postId) {
        postLikeService.unLike(userDetails, postId);
    }

}
