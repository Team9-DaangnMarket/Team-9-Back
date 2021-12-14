package com.sparta.team9back.dto.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String nickname;

}