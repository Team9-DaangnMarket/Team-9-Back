package com.sparta.team9back.service;

import com.sparta.team9back.dto.MyDetailResponseDto;
import com.sparta.team9back.dto.MyPostLikeResponseDto;
import com.sparta.team9back.model.PostLike;
import com.sparta.team9back.model.User;
import com.sparta.team9back.repository.PostLikeRepository;
import com.sparta.team9back.security.UserDetailsImpl;
import com.sparta.team9back.validator.UserInfoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyDetailService {
    private final PostLikeRepository postLikeRepository;



}
