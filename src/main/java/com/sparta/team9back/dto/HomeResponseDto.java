package com.sparta.team9back.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class HomeResponseDto {
    private Long postId;
    private String username;
    private String nickname;
    private String title;
    private int price;
    private String goodsImg;
    private int postLikes;
    private LocalDateTime createdAt;

    // boolean nextPage;
}