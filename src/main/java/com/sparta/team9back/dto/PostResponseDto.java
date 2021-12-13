package com.sparta.team9back.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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