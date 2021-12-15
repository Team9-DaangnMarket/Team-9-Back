package com.sparta.team9back.controller;

import com.sparta.team9back.dto.MyDetailResponseDto;
import com.sparta.team9back.security.UserDetailsImpl;
import com.sparta.team9back.service.MyDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyDetailController {
    private MyDetailService myDetailService;

    @GetMapping("/user/details")
    public ResponseEntity<MyDetailResponseDto> getPostLike(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        MyDetailResponseDto myDetailResponseDto = myDetailService.getPostLike(userDetails);

        return ResponseEntity.ok()
                .body(myDetailResponseDto);
    }
}
