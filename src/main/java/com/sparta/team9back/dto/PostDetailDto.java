package com.sparta.team9back.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostDetailDto {
    private Long postId;
    private String nickname;
    private String username;
    private String title;
    private String content;
    private int price;
    private String goodsImg;
    private boolean negoCheck;
    private String category;
    private Integer visitCount; // int아닌가?
    private List<PostInsideDto> insideList;
}
