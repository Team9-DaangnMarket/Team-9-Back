package com.sparta.team9back.service;

import com.sparta.team9back.dto.MyDetailResponseDto;
import com.sparta.team9back.model.Recommend;
import com.sparta.team9back.model.User;
import com.sparta.team9back.repository.RecommendRepository;
import com.sparta.team9back.security.UserDetailsImpl;
import com.sparta.team9back.validator.UserInfoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyDetailService {
    private final RecommendRepository recommendRepository;

    public  MyDetailResponseDto getRecommend(UserDetailsImpl userDetails) {
        User user = UserInfoValidator.userDetailsIsNull(userDetails);

        List<Recommend> recommendList = recommendRepository.findAllByUser(user);


        return new MyDetailResponseDto(recommendList);
    }

}
