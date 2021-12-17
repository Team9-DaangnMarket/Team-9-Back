package com.sparta.team9back.model;

import com.sparta.team9back.dto.User.SignupRequestDto;
import com.sparta.team9back.validator.UserInfoValidator;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @DisplayName("회원가입 객체 생성")
    class createUser {
        private String username;
        private String nickname;
        private String password;
        private String profileImg;

        @BeforeEach
        void setUp() {
            username = "zmon";
            nickname = "yckk1";
            password = "asdf1231!";
            profileImg = "default.img";
        }

        @Test
        @DisplayName("회원가입")
        void signUpTest() {

//        SignupRequestDto signupRequestDto = SignupRequestDto.builder()
//                .password(password)
//                .username(username)
//                .nickname(nickname)
//                .profileImg(profileImg)
//                .build();

            SignupRequestDto signupRequestDto = new SignupRequestDto(
                    username, password, nickname, profileImg
            );

            User user = new User(signupRequestDto, password);
            assertNull(user.getId());
            assertEquals(username, user.getUsername());
            assertEquals(password, user.getPassword());
            assertEquals(profileImg, user.getProfileImg());
            assertEquals(nickname, user.getNickname());

        }

        @Test
        @DisplayName("토큰 생성 ")
        void createTokenTest() {

        }
    }
}