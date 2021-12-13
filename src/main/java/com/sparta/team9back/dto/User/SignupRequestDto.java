package com.sparta.team9back.dto.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupRequestDto {


    private String username;
    private String password;
    private String nickname;

}