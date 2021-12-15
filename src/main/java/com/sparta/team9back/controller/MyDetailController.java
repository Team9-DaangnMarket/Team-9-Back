package com.sparta.team9back.controller;

import com.sparta.team9back.dto.MyDetailResponseDto;
import com.sparta.team9back.dto.MyPostLikeResponseDto;
import com.sparta.team9back.security.UserDetailsImpl;
import com.sparta.team9back.service.MyDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyDetailController {
    private MyDetailService myDetailService;

    //관심목록 추가 한 게시물 불러오기
    @GetMapping("/user/details")
    public ResponseEntity<MyPostLikeResponseDto> getMyPostLike(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println(userDetails.getUser()+"컨트롤러");
        MyPostLikeResponseDto myPostLikeResponseDto = myDetailService.getMyPostLike(userDetails);
        System.out.println(myPostLikeResponseDto);
        return ResponseEntity.ok()
                .body(myPostLikeResponseDto);
    }
}
