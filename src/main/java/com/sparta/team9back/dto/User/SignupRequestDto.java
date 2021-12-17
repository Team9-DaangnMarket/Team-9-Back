package com.sparta.team9back.dto.User;

import jdk.jfr.StackTrace;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class SignupRequestDto {
    private String username;
    private String password;
    private String nickname;
    private String profileImg;
}