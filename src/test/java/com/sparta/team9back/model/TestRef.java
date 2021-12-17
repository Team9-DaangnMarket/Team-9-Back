package com.sparta.team9back.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.team9back.dto.User.UserInfoDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestRef {
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    private HttpHeaders headers;
//    private ObjectMapper mapper = new ObjectMapper();
//
//    private final List<UserInfoDto> userInfoDtos = new ArrayList<>();
//
//    @BeforeEach
//    public void setup() {
//        headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//    }
//
//    @Nested
//    @DisplayName("음식점 3개 등록 및 조회")
//    class RegisterUser {
//        @Test
//        @Order(1)
//        @DisplayName("음식점1 등록")
//        void test1() throws JsonProcessingException {
//            // given
//            UserInfoDto request = UserInfoDto.builder()
//                    .id(null)
//                    .name("쉐이크쉑 청담점")
//                    .minOrderPrice(1_000)
//                    .deliveryFee(0)
//                    .build();
//
//            String requestBody = mapper.writeValueAsString(request);
//            HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
//
//            // when
//            ResponseEntity<RestaurantDto> response = restTemplate.postForEntity(
//                    "/restaurant/register",
//                    request,
//                    RestaurantDto.class);
//
//            // then
//            assertEquals(HttpStatus.OK, response.getStatusCode());
//
//            RestaurantDto UserResponse = response.getBody();
//            assertNotNull(UserResponse);
//            assertTrue(UserResponse.id > 0);
//            assertEquals(request.name, UserResponse.name);
//            assertEquals(request.minOrderPrice, UserResponse.minOrderPrice);
//            assertEquals(request.deliveryFee, UserResponse.deliveryFee);
//
//            // 음식점 등록 성공 시, registeredRestaurants 에 추가
//            registeredRestaurants.add(UserResponse);
//        }
//    }
//
//    @Getter
//    @Setter
//    @Builder
//    static class SignupRequestDto {
//    }
}