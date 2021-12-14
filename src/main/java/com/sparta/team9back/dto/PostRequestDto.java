package com.sparta.team9back.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostRequestDto {
    private String title;
    private String content;
    private int price;
    private String goodsImg;
    private Boolean negoCheck;
    private String category;
}
