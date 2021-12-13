package com.sparta.team9back.validator;

import com.sparta.team9back.dto.User.SignupRequestDto;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

public class UserInfoValidator {
    public static void validateUserInfoInput(SignupRequestDto requestDto) {
        String patternUsername = "^(.+)@(.+)$";
//        String patternNickname = "[^!@#$%^&*(),.?\\\":{}|<>]{2,}";

        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();
        String username = requestDto.getUsername();

        // 닉네임 형식 확인
//        if(nickname == null || !Pattern.matches(patternNickname, nickname)) {
//            throw new IllegalArgumentException("최소 2자 이상, 특수문자는 포함될 수 없습니다.");
//        }

        // 비밀번호 형식 확인
        if(password == null || password.length() < 4){
            throw new IllegalArgumentException("최소 4자 이상이어야 합니다.");
        }

        // 아이디 형식 검사
//        if(userId == null || !Pattern.matches(patternUserId, userId)) {
//            throw new IllegalArgumentException("최소 2자 이상, 특수문자는 포함될 수 없습니다.");
//        }
    }
}
