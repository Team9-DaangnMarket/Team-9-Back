package com.sparta.team9back.service;

import com.sparta.team9back.dto.User.SignupRequestDto;
import com.sparta.team9back.model.User;
import com.sparta.team9back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();

        if(userRepository.existsByUsername(username)){
            throw new IllegalArgumentException("중복된 아이디 입니다.");
        }

        // 패스워드
        String enPassword = passwordEncoder.encode(requestDto.getPassword());

        System.out.println("저장됨? >.<");

        // 유저 생성
        User user = new User(requestDto, enPassword);
        System.out.println(user);
        userRepository.save(user); // DB 저장
    }



}