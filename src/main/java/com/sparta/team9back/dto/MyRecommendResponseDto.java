package com.sparta.team9back.dto;

import com.sparta.team9back.model.Recommend;

public class MyRecommendResponseDto {
    private Long recommendId;
    private String title;
    private int price;
    private String goodsImg;

    public MyRecommendResponseDto(Recommend recommend) {
        this.recommendId = recommend.getRecommendId();
        this.title = recommend.getPost().getTitle();
        this.price = recommend.getPost().getPrice();
        this.goodsImg = recommend.getPost().getGoodsImg();
    }

}
