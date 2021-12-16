package com.sparta.team9back.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MyDetailResponseDto {
    private List<MyPostLikeResponseDto> myPostLikes;
}
