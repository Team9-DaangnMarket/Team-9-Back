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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyDetailService {
    private final PostLikeRepository postLikeRepository;

    public MyPostLikeResponseDto getMyPostLike(UserDetailsImpl userDetails) {
//        User user = UserInfoValidator.userDetailsIsNull(userDetails);
        System.out.println(userDetails.getUser());
//        Optional<PostLike> postLike = postLikeRepository.findAllByUserId(userDetails.getUser());
//        if (!postLike.isPresent()) {
//            System.out.println("이거 너가 좋아요한거 아닌데?!");
//            throw new NullPointerException("당신의 관심목록이 아니거나 관심목록이 없습니다.");
//        }
        System.out.println("좋아요 목록 가져라!");
        MyPostLikeResponseDto A = MyPostLikeResponseDto.builder()
                .price(5000)
                .title("바보다나는")
                .build();
        return A;
    }
}
