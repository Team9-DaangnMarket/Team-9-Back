package com.sparta.team9back.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostResponseDto {
    String username;
    String title;
    String content;
    int price;
    String goodsImg;
    boolean negoCheck;
    String category;
}