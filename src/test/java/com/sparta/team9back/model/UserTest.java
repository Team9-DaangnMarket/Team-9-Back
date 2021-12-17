package com.sparta.team9back.model;

import com.sparta.team9back.dto.User.SignupRequestDto;
import com.sparta.team9back.validator.UserInfoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    String username = "zmon";
    String nickname = "yc";     //에러
    String password = "asdfasdf1!";
    String profileImg = "default.img";

    SignupRequestDto requestDto = SignupRequestDto.builder()
            .username(username)
            .nickname(nickname)
            .profileImg(profileImg)
            .build();

    User user = new User(requestDto, password);

    assertEquals(username, user.getUsername());
}

import com.sparta.springcore.dto.ProductRequestDto;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    @DisplayName("정상 케이스")
    void createProduct_Normal() {
// given
        Long userId = 100L;
        String title = "오리온 꼬북칩 초코츄러스맛 160g";
        String image = "https://shopping-phinf.pstatic.net/main_2416122/24161228524.20200915151118.jpg";
        String link = "https://search.shopping.naver.com/gate.nhn?id=24161228524";
        int lprice = 2350;

        ProductRequestDto requestDto = new ProductRequestDto(
                title,
                image,
                link,
                lprice
        );

// when
        Product product = new Product(requestDto, userId);

// then
        assertNull(product.getId());
        assertEquals(userId, product.getUserId());
        assertEquals(title, product.getTitle());
        assertEquals(image, product.getImage());
        assertEquals(link, product.getLink());
        assertEquals(lprice, product.getLprice());
        assertEquals(0, product.getMyprice());
    }
}