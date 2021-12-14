package com.sparta.team9back.dto.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserInfoDto {
    private String username;
    private String nickname;
    private String password;
}
