package com.sparta.team9back.dto;

import com.sparta.team9back.model.PostLike;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MyDetailResponseDto {
    List<MyPostLikeResponseDto> myPostLikes = new ArrayList<>();

    public MyDetailResponseDto(List<PostLike> postLikeList) {
        for (PostLike postLike : postLikeList) {
            this.myPostLikes.add(new MyPostLikeResponseDto(postLike));
        }
    }
}
