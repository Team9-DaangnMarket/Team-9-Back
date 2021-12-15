package com.sparta.team9back.dto;

import com.sparta.team9back.model.Category;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class CategoryResponseDto {
    private Long categoryId;
    private String category;
}
