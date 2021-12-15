package com.sparta.team9back.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    // boolean nextPage;
}