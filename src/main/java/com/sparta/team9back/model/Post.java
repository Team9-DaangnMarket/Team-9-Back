package com.sparta.team9back.model;

import com.sparta.team9back.dto.PostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false) // , columnDefinition = "LONGTEXT"
    private String content;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String goodsImg;

    @Column(nullable = false)
    private Boolean negoCheck;

    @Column
    private String category;

    @Column
    private int likeCount;


    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.price = postRequestDto.getPrice();
        this.goodsImg = postRequestDto.getGoodsImg();
        this.negoCheck = postRequestDto.getNegoCheck();
        this.category = postRequestDto.getCategory();
    }
}
