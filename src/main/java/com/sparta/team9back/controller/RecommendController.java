package com.sparta.team9back.controller;

import com.sparta.team9back.repository.RecommendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RecommendController {
    private final RecommendRepository recommendRepository;

}
