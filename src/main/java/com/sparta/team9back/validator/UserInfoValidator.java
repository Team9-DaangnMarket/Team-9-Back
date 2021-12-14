package com.sparta.team9back.validator;

import com.sparta.team9back.dto.User.SignupRequestDto;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

public class UserInfoValidator {
    public static void validateUserInfoInput(SignupRequestDto requestDto) {
        String patternUsername = "^[a-zA-Z0-9]{3,20}$";
        String patternNickname = "^[a-zA-Z0-9]{3,10}$";
        String patternPassword = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$";

        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();
        String username = requestDto.getUsername();

        // 닉네임 형식 확인
        if(nickname == null || !Pattern.matches(patternNickname, nickname)) {
            throw new IllegalArgumentException(" 3자이상 10자 이하로 가능합니다.");
        }

        // 비밀번호 형식 확인
        if(password == null || !Pattern.matches(patternPassword, password)){
            throw new IllegalArgumentException("영문 & 숫자 & 특수기호 포함 8자이상 20자이하로 가능합니다.");
        }

        // 아이디 형식 검사
       if(username == null || !Pattern.matches(patternUsername, username)) {
          throw new IllegalArgumentException("영문포함 3자이상 20자이하 가능합니다.");
       }
    }
}
