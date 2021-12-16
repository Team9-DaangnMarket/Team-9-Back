package com.sparta.team9back.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyPostLikeResponseDto {
    private Long postId;
    private String title;
    private int price;
    private String goodsImg;
    private Boolean likeCheck;
    private int postLikes;

}
