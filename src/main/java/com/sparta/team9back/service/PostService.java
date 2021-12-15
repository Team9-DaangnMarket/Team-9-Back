package com.sparta.team9back.service;

import com.sparta.team9back.dto.PostDetailDto;
import com.sparta.team9back.dto.PostInsideDto;
import com.sparta.team9back.dto.PostRequestDto;
import com.sparta.team9back.dto.PostResponseDto;
import com.sparta.team9back.model.Post;
import com.sparta.team9back.model.User;
import com.sparta.team9back.repository.PostRepository;
import com.sparta.team9back.repository.UserRepository;
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
    private final UserRepository userRepository;

    @Transactional
    public PostResponseDto createPost(PostRequestDto postRequestDto, User user) {

        Post post = Post.builder()
                .user(user)
                .goodsImg(postRequestDto.getGoodsImg())
                .title(postRequestDto.getTitle())
                .content(postRequestDto.getContent())
                .negoCheck(postRequestDto.getNegoCheck())
                .category(postRequestDto.getCategory())
                .price(postRequestDto.getPrice())
                .build();

        postRepository.save(post);

        return PostResponseDto.builder()

                .nickname(user.getNickname())
                .username(user.getUsername())
                .title(postRequestDto.getTitle())
                .content(postRequestDto.getContent())
                .category(postRequestDto.getCategory())
                .goodsImg(postRequestDto.getGoodsImg())
                .price(postRequestDto.getPrice())
                .negoCheck(postRequestDto.getNegoCheck())
                .build();
    }

    @Transactional      //리스트로 보내기
    public PostDetailDto showDetail(Long postId, User user) {

        Post post = postRepository.findById(postId).orElse(null);
        if (post == null) {
            throw new NullPointerException("해당 게시글 정보가 존재하지 않습니다.");
        }


        List<Post> postList = postRepository.findAllByUserOrderByPostIdDesc(user);

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

        Post postMain = postRepository.findById(postId).orElse(null);

        return PostDetailDto.builder()
                .postId(postId)
                .nickname(postMain.getUser().getNickname())
                .username(postMain.getUser().getUsername())
                .title(post.getTitle())
                .content(post.getContent())
                .category(post.getCategory())
                .goodsImg(post.getGoodsImg())
                .price(post.getPrice())
                .negoCheck(post.getNegoCheck())
                .insideList(postInsideDtos)
                .build();
    }

    @Transactional
    public void updatePost(Long postId, PostRequestDto postRequestDto, User user) {
        Post post = postRepository.findByUserAndPostId(user, postId).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        post.update(postRequestDto);
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
}
