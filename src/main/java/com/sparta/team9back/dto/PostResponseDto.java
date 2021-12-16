package com.sparta.team9back.dto;

import com.sparta.team9back.model.Category;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostResponseDto {
    private String nickname;
    private String username;
    private String title;
    private String content;
    private int price;
    private String goodsImg;
    private boolean negoCheck;
    private String categoryName;
    //Boolean likeCheck;
}
