package com.sparta.team9back.service;

import com.sparta.team9back.dto.PostDetailDto;
import com.sparta.team9back.dto.PostInsideDto;
import com.sparta.team9back.dto.PostRequestDto;
import com.sparta.team9back.dto.PostResponseDto;
import com.sparta.team9back.model.Category;
import com.sparta.team9back.model.Post;
import com.sparta.team9back.model.User;
import com.sparta.team9back.repository.CategoryRepository;
import com.sparta.team9back.repository.PostLikeRepository;
import com.sparta.team9back.repository.PostRepository;
import com.sparta.team9back.security.UserDetailsImpl;
import com.sparta.team9back.validator.UserInfoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    private final CategoryRepository categoryRepository;

    @Transactional // 이걸 잊지 않았나 하는 생각.
    public PostResponseDto createPost(PostRequestDto postRequestDto, User user) {

        String categoryName = postRequestDto.getCategoryName();
        Category category= categoryRepository.findByCategoryName(categoryName).orElseThrow(
                () -> new NullPointerException("해당 카테고리명이 존재하지 않습니다.")
        );

        Post post = Post.builder()
                .user(user)
                .title(postRequestDto.getTitle())
                .content(postRequestDto.getContent())
                .price(postRequestDto.getPrice())
                .goodsImg(postRequestDto.getGoodsImg())
                .negoCheck(postRequestDto.getNegoCheck())
                .category(category)
                .build();

        postRepository.save(post);

        return PostResponseDto.builder()

                .nickname(user.getNickname())
                .username(user.getUsername())
                .title(postRequestDto.getTitle())
                .content(postRequestDto.getContent())
                .category(category)
                .goodsImg(postRequestDto.getGoodsImg())
                .price(postRequestDto.getPrice())
                .negoCheck(postRequestDto.getNegoCheck())
                .build();
    }

    @Transactional      //리스트로 보내기
    public PostDetailDto showDetail(Long postId, User user) {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new NullPointerException("해당 게시글 정보가 존재하지 않습니다.")
        );

        //Post postMain = postRepository.findByPostId(postId).orElse(null);
        List<Post> postList = postRepository.findAllByUserOrderByPostIdDesc(post.getUser());

        List<PostInsideDto> postInsideDtos = new ArrayList<>();
        for (Post insidePost : postList) {
            if (postInsideDtos.size() == 4) break;
            if (insidePost.getPostId().equals(postId)) continue;

            Long insideId = insidePost.getPostId();
            String title = insidePost.getTitle();
            int price = insidePost.getPrice();
            String goodsImg = insidePost.getGoodsImg();

            postInsideDtos.add(new PostInsideDto(insideId, title, price, goodsImg));
        }

        Boolean likeCheck = postLikeRepository.existsByUserAndPost(post.getUser(), post);
        postRepository.upVisitCnt(postId);

        return PostDetailDto.builder()
                .postId(postId)
                .nickname(post.getUser().getNickname())
                .username(post.getUser().getUsername())
                .title(post.getTitle())
                .content(post.getContent())
                .category(post.getCategory())
                .goodsImg(post.getGoodsImg())
                .price(post.getPrice())
                .negoCheck(post.getNegoCheck())
                .visitCount(post.getVisitCount())
                .createdAt(post.getCreatedAt())
                .insideList(postInsideDtos)
                .likeCheck(likeCheck)
                .build();
    }

    @Transactional
    public void updatePost(Long postId, PostRequestDto postRequestDto, User user) {
        Post post = postRepository.findByUserAndPostId(user, postId).orElseThrow(
                () -> new NullPointerException("해당 게시글이 존재하지 않습니다.")
        );

        Category category= categoryRepository.findByCategoryName(postRequestDto.getCategoryName()).orElseThrow(
                () -> new NullPointerException("해당 카테고리명이 존재하지 않습니다.")
        );

        post.update(postRequestDto, category);
    }

    @Transactional
    public void deletePost(Long postId, UserDetailsImpl userDetails) {
        User user = UserInfoValidator.userDetailsIsNull(userDetails);

        Optional<Post> post = postRepository.findById(postId);
        if (!post.isPresent()) {
            throw new NullPointerException("유효하지 않거나 이미 삭제된 글입니다.");
        }
        if (!user.getId().equals(post.get().getUser().getId())) {
            throw new IllegalArgumentException("당신의 게시글이 아닙니다.");
        }
        postRepository.deleteById(postId);
    }
    // 댓글을 추가할 경우, 그리고 Post와 Comment entity 간에 cascade 설정을 해놓지 않은 경우
    // 댓글이 달린 게시글을 삭제할 때 Service에서 게시글에 달린 댓글을 전부 삭제하는 작업이 선행될 필요가 있음

}
