package com.sparta.team9back.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sparta.team9back.dto.PostRequestDto;
import lombok.*;

import javax.persistence.*;

import java.util.List;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post extends Timestamped {
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


    @JsonIgnoreProperties({"post"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostLike> likeList;

    @Column
    private int postLikes;

//    @Column
//    private Integer visitCount;


    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.price = postRequestDto.getPrice();
        this.goodsImg = postRequestDto.getGoodsImg();
        this.negoCheck = postRequestDto.getNegoCheck();
        this.category = postRequestDto.getCategory();
    }
}
