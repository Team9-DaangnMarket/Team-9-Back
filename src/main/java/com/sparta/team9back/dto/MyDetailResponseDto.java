package com.sparta.team9back.dto;

import com.sparta.team9back.model.Recommend;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MyDetailResponseDto {
    List<MyRecommendResponseDto> myRecommends = new ArrayList<>();

    public MyDetailResponseDto(List<Recommend> recommendList) {
        for (Recommend recommend : recommendList) {
            this.myRecommends.add(new MyRecommendResponseDto(recommend));
        }
    }
}
