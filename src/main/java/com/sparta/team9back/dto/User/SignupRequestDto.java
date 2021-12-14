package com.sparta.team9back.dto.User;

import lombok.Getter;


@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String nickname;
    private String profileImg;
}