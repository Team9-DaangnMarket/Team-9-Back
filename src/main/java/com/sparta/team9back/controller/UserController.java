package com.sparta.team9back.controller;

import com.sparta.team9back.dto.User.CheckIdResponseDto;
import com.sparta.team9back.dto.User.CheckNicknameResponseDto;
import com.sparta.team9back.dto.User.CheckIdRequestDto;
import com.sparta.team9back.dto.User.CheckNicknameRequestDto;
import com.sparta.team9back.dto.User.SignupRequestDto;
import com.sparta.team9back.dto.User.UserInfoDto;
import com.sparta.team9back.model.User;
import com.sparta.team9back.security.UserDetailsImpl;
import com.sparta.team9back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //회원가입
    @PostMapping("/user/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);

        return ResponseEntity.ok()
                .body("회원가입 완료");
    }

    @PostMapping("/userInfo")
    public ResponseEntity<UserInfoDto> getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        UserInfoDto userInfoDto = new UserInfoDto(user.getUsername(), user.getNickname(), user.getPassword());
        return ResponseEntity.ok()
                .body(userInfoDto);
    }

    @PostMapping("/user/checkId")
    public ResponseEntity<CheckIdResponseDto> checkId(@RequestBody CheckIdRequestDto checkIdRequestDto) {
        CheckIdResponseDto checkIdResponseDto = userService.checkId(checkIdRequestDto);

        return ResponseEntity.ok()
                .body(checkIdResponseDto);
    }

    @PostMapping("/user/checkNickname")
    public ResponseEntity<CheckNicknameResponseDto> checkNickname(@RequestBody CheckNicknameRequestDto checkNicknameRequestDto) {
        CheckNicknameResponseDto checkNicknameResponseDto = userService.checkNickname(checkNicknameRequestDto);

        return ResponseEntity.ok()
                .body(checkNicknameResponseDto);
    }

}
