package com.sparta.team9back.service;

import com.sparta.team9back.dto.PostDetailDto;
import com.sparta.team9back.dto.PostInsideDto;
import com.sparta.team9back.dto.PostRequestDto;
import com.sparta.team9back.dto.PostResponseDto;
import com.sparta.team9back.model.Post;
import com.sparta.team9back.model.User;
import com.sparta.team9back.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional // 이걸 잊지 않았나 하는 생각.
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

        PostDetailDto postDetailDto = new PostDetailDto();
        List<PostInsideDto> postInsideDtos = new ArrayList<>();

        for (PostInsideDto postInsideDto : postDetailDto.getInsideList()) {

            Post insidePost = postRepository.findByTitle(postInsideDto.getTitle()).orElse(null);
            if (insidePost != null && insidePost.getPostId().equals(postId)) continue;
            // 판매자의 다른 상품란에 표시될 목록 중 "다른 상품"이 아닌 "상세 페이지에 이미 게시된 상품"은 제외해야
            // if (어쩌고저쩌고) continue; insidePost가 null인 경우도 상정해야.
            // 4개씩 보이는 건 잘 모르겠다. pageable 을 어떻게 잘 활용하면 될 것 같은데 개념 이해가 부족.

            String title = postInsideDto.getTitle();
            int price = postInsideDto.getPrice();
            String goodsImg = postInsideDto.getGoodsImg();
            // 작성자가 동일한 것만 더하고 싶다. 그러면 어떻게? 일단 if문을 써야 한다는 것 자체는 알겠는데.

            if (insidePost != null && user.equals(insidePost.getUser())) {
                postInsideDtos.add(new PostInsideDto(title, price, goodsImg));
            }
        }
        // 이 부분은 좀 무거워보여서 이후 refactoring 작업 때 다른 method로 내보내야 할 듯.


        return PostDetailDto.builder()
                .username(user.getUsername())
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
    public void deletePost(Long postId, User user) {
        Long checkId = postRepository.findByUser(user).orElse(null).getPostId();
        if(checkId.equals(postId))
            postRepository.deleteById(postId);
        // 댓글을 추가할 경우, 그리고 Post와 Comment entity 간에 cascade 설정을 해놓지 않은 경우
        // 댓글이 달린 게시글을 삭제할 때 Service에서 게시글에 달린 댓글을 전부 삭제하는 작업이 선행될 필요가 있음
    }
}
