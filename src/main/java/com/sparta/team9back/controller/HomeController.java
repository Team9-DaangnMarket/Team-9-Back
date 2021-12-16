package com.sparta.team9back.controller;

import com.sparta.team9back.dto.HomeResponseDto;
import com.sparta.team9back.dto.PostResponseDto;
import com.sparta.team9back.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final HomeService homeService;

    // 모든 포스트 보여주기
    @GetMapping("/posts")
    public List<HomeResponseDto> getAllPosts(@RequestParam int page, @RequestParam int size) {
        Pageable sortedByPostIdDesc = PageRequest.of(page, size, Sort.by("postId").descending());
        return homeService.findAllPosts(sortedByPostIdDesc);
    }

    // 키워드별 검색. 당근마켓은 가격대별 검색 기능도 있어야 할 것 같은데;
    @GetMapping("/search")
    public List<HomeResponseDto> getSearchedPost(@RequestParam String keyword, @RequestParam int page, @RequestParam int size) {
        return homeService.searchPosts(keyword, page, size);
    }
}
