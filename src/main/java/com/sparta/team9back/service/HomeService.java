package com.sparta.team9back.service;

import com.sparta.team9back.dto.HomeResponseDto;
import com.sparta.team9back.model.Post;
import com.sparta.team9back.repository.PostRepository;
import com.sparta.team9back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<HomeResponseDto> findAllPosts(Pageable pageable) {
        List<Post> posts = postRepository.findAllByOrderByPostIdDesc(pageable).getContent();
        List<HomeResponseDto> allPosts = new ArrayList<>();
        for (Post post : posts) {
            HomeResponseDto responseDto = createPostDto(post);
            allPosts.add(responseDto);
        }
        return allPosts;
    }

    private HomeResponseDto createPostDto(Post post) {

        return new HomeResponseDto(
                post.getPostId(),
                post.getUser().getUsername(),
                post.getUser().getNickname(),
                post.getTitle(),
                post.getPrice(),
                post.getGoodsImg(),
                post.getPostLikes(),
                post.getCreatedAt()
        );
    }

    @Transactional
    public List<HomeResponseDto> searchPosts(String keyword, int pageNumber, int size) {

        List<Post> posts = postRepository.findAllByOrderByModifiedAtDesc();
        posts.removeIf(post -> !(post.getTitle().contains(keyword) || post.getContent().contains(keyword)));
        // 카테고리명으로도 검색하고 싶었으나 위의 항목에 || post.getCategory().getCategoryName().contains(keyword)를 넣으니 오작동. posts.remofeIf 전후로 System.out.println(posts); 를 집어넣은 결과 전에는
        // 자료형태가 정확히 표기되진 않아도 뭔가 잔뜩 들어가있었다면 후에는 아예 출력 자체를 거부함. []조차 아님.

        PagedListHolder<Post> page = new PagedListHolder<>(posts);
        page.setPageSize(size);
        page.setPage(pageNumber);
        posts = page.getPageList();

        List<HomeResponseDto> searchedPosts = new ArrayList<>();
        for (Post post : posts) {
            HomeResponseDto responseDto = createPostDto(post);
            searchedPosts.add(responseDto);
        }

        return searchedPosts;
    }
}
