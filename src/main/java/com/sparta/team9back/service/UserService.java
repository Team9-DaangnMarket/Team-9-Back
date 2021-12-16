package com.sparta.team9back.service;

import com.sparta.team9back.dto.User.CheckIdResponseDto;
import com.sparta.team9back.dto.User.CheckNicknameResponseDto;
import com.sparta.team9back.dto.User.CheckIdRequestDto;
import com.sparta.team9back.dto.User.CheckNicknameRequestDto;
import com.sparta.team9back.dto.User.SignupRequestDto;
import com.sparta.team9back.model.User;
import com.sparta.team9back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String nickname = requestDto.getNickname();

        if(userRepository.existsByUsername(username)){
            throw new IllegalArgumentException("중복된 아이디 입니다.");
        }
        if(userRepository.existsByNickname(nickname)){
            throw new IllegalArgumentException("중복된 닉네임 입니다.");
        }

        // 패스워드
        String enPassword = passwordEncoder.encode(requestDto.getPassword());

        System.out.println("저장됨? >.<");

        // 유저 생성
        User user = new User(requestDto, enPassword);
        userRepository.save(user); // DB 저장
    }

    public CheckIdResponseDto checkId(CheckIdRequestDto checkIdRequestDto) {
        Optional<User> user = userRepository.findByUsername(checkIdRequestDto.getUsername());
        // isPresent = true 일 때 = 중복이므로 가입 불가(false) 출력
        return new CheckIdResponseDto(!user.isPresent());
    }
    public CheckNicknameResponseDto checkNickname(CheckNicknameRequestDto checkNicknameRequestDto) {
        Optional<User> user = userRepository.findByNickname(checkNicknameRequestDto.getNickname());
        // isPresent = true 일 때 = 중복이므로 가입 불가(false) 출력
        return new CheckNicknameResponseDto(!user.isPresent());
    }
}