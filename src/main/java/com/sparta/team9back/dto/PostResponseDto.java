package com.sparta.team9back.dto;

import com.sparta.team9back.model.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@Builder
public class PostResponseDto {
    String username;
    String title;
    String content;
    int price;
    String goodsImg;
    boolean negoCheck;
    Category category;
}