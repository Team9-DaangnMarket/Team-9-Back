package com.sparta.team9back.dto;

import com.sparta.team9back.model.PostLike;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MyPostLikeResponseDto {
    private Long postLikeId;
    private String title;
    private int price;
    private String goodsImg;


    public MyPostLikeResponseDto(PostLike postLike) {
        this.postLikeId = postLike.getPostLikeId();
        this.title = postLike.getPost().getTitle();
        this.price = postLike.getPost().getPrice();
        this.goodsImg = postLike.getPost().getGoodsImg();
    }

}
