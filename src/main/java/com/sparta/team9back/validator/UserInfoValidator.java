package com.sparta.team9back.validator;

import com.sparta.team9back.dto.User.SignupRequestDto;
import com.sparta.team9back.model.User;
import com.sparta.team9back.security.UserDetailsImpl;


import java.util.regex.Pattern;

public class UserInfoValidator {
    public static User userDetailsIsNull(UserDetailsImpl userDetails) {
        if(userDetails != null){
            return userDetails.getUser();
        }else{
            throw new NullPointerException("유효하지 않은 사용자입니다.");
            // 이 부분은 어떻게 검사해야 할지 잘 몰라서 보류.
        }
    }
    public static void validateUserInfoInput(SignupRequestDto requestDto) {


        String patternUsername = "^[a-zA-Z0-9]{3,20}$";
        String patternNickname = "^[a-zA-Z0-9]{3,10}$";
        String patternPassword = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$";

        String nickname = requestDto.getNickname();
        String password = requestDto.getPassword();
        String username = requestDto.getUsername();

        // 닉네임 형식 확인
        if(nickname == null || !Pattern.matches(patternNickname, nickname)) {
            throw new IllegalArgumentException("영문 & 숫자 포함 3자 이상 10자 이하로 가능합니다.");
        }

        // 비밀번호 형식 확인
        if(password == null || !Pattern.matches(patternPassword, password)){
            throw new IllegalArgumentException("영문 & 숫자 & 특수기호 포함 8자 이상 20자 이하로 가능합니다.");
        }

        // 아이디(username) 형식 검사
       if(username == null || !Pattern.matches(patternUsername, username)) {
          throw new IllegalArgumentException("영문 & 숫자 포함 3자 이상 20자 이하로 가능합니다.");
       }
    }
}
