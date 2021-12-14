package com.sparta.team9back.model;

// >.<
import com.sparta.team9back.dto.User.SignupRequestDto;
import com.sparta.team9back.validator.UserInfoValidator;
import com.sparta.team9back.validator.UserInfoValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //userId == 사용자 ID
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;


    public User(SignupRequestDto requestDto, String enPassword){
        UserInfoValidator.validateUserInfoInput(requestDto);
        this.username = requestDto.getUsername();
        this.nickname = requestDto.getNickname();
        this.password = enPassword;
    }

    public User(String nickname, String encodedPassword, String userId) {
        this.username = userId;
        this.nickname = nickname;
        this.password = encodedPassword;

    }

//    public void  update(SignupRequestDto requestDto) {
//        UserInfoValidator.validateUserInfoInput(requestDto);
//
//        this.username = requestDto.getUserId();
//        this.nickname = requestDto.getNickname();
//
//    }
}
