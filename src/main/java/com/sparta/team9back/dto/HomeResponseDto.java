package com.sparta.team9back.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class HomeResponseDto {
    Long postId;
    String username;
    String nickname;
    String title;
    int price;
    String goodsImg;
    int postLikes;

    // boolean nextPage;
}
