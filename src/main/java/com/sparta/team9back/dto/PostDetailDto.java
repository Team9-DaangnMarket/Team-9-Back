package com.sparta.team9back.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.team9back.model.Category;
import lombok.*;

import java.time.LocalDateTime;
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
    private Category category;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
//    private int visitCount; // int아닌가?
    private List<PostInsideDto> insideList;
}
