package com.sparta.team9back.controller;

import com.sparta.team9back.dto.User.SignupRequestDto;
import com.sparta.team9back.dto.User.UserInfoDto;
import com.sparta.team9back.model.User;
import com.sparta.team9back.security.UserDetailsImpl;
import com.sparta.team9back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/user/signup")
    public void registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);

    }
    @PostMapping("/userinfo")
    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return new UserInfoDto(user.getUsername(), user.getNickname(), user.getPassword());
    }

}