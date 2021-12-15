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
            // 판매자의 다른 상품란에 표시될 목록 중 "다른 상품"이 아닌 "상세 페이지에 이미 게시된 상품"은 제외해야
            // if (어쩌고저쩌고) continue; insidePost가 null인 경우도 상정해야.
            // 4개씩 보이는 건 잘 모르겠다. pageable 을 어떻게 잘 활용하면 될 것 같은데 개념 이해가 부족.

            Long insideId = insidePost.getPostId();
            String title = insidePost.getTitle();
            int price = insidePost.getPrice();
            String goodsImg = insidePost.getGoodsImg();
            // 작성자가 동일한 것만 더하고 싶다. 그러면 어떻게? 일단 if문을 써야 한다는 것 자체는 알겠는데.

                postInsideDtos.add(new PostInsideDto(insideId, title, price, goodsImg));
        }
        // 이 부분은 좀 무거워보여서 이후 refactoring 작업 때 다른 method로 내보내야 할 듯.


        return PostDetailDto.builder()
                .postId(postId)
                .nickname(user.getNickname())
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

//    @Transactional
//    public void deletePost(Long postId, User user) {
//        userRepository.delete(userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException(User.class, user.getId())));
//    }
//    @Transactional
//    public void deletePost(Long postId, User user) {
////        Long checkId = postRepository.findByUser(user).orElse(null).getPostId();
////        if(checkId.equals(postId))
//        Post post = postRepository.findByUser(user).orElse(null);
//        assert post != null;
//        if ( postId.equals(post.getUser().getId())) {
//            postRepository.deleteById(postId);
//        }

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
