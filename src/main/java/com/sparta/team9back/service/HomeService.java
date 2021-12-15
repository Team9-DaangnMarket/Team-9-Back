package com.sparta.team9back.service;

import com.sparta.team9back.dto.HomeResponseDto;
import com.sparta.team9back.model.Post;
import com.sparta.team9back.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final PostRepository postRepository;

    public List<HomeResponseDto> findAllPosts(PageRequest pageable) {
        List<Post> posts = postRepository.findAllByOrderByPostIdDesc(pageable).getContent();
        List<HomeResponseDto> allPosts = new ArrayList<>();
        for (Post post : posts) {
            HomeResponseDto responseDto = createPostDto(post);
            allPosts.add(responseDto);
        }
        return allPosts;
    }

    private HomeResponseDto createPostDto(Post post) {

        String name = "abc";

        return new HomeResponseDto(
                name,
                post.getTitle(),
                post.getPrice(),
                post.getGoodsImg(),
                post.getPostLikes()
        );
    }
}
