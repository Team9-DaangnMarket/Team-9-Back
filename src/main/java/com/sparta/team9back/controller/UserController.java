package com.sparta.team9back.controller;

import com.sparta.team9back.dto.User.SignupRequestDto;
import com.sparta.team9back.security.UserDetailsImpl;
import com.sparta.team9back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/user/signup")
    public void registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);

    }



}





//}