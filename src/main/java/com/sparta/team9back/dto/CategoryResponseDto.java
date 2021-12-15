package com.sparta.team9back.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryResponseDto {
    private Long categoryId;
    private String category;
}