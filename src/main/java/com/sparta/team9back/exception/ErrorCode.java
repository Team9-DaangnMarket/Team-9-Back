package com.sparta.team9back.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    // 400 Bad Request
    // UserInfoValidator - IllegalArgumentException(회원 가입 양식) - 원래는 500 error로 뜨던 것들
    OUTBOUND_USERNAME(HttpStatus.BAD_REQUEST, "400_1", "영문 & 숫자 포함 3자 이상 20자 이하로 가능합니다."),
    OUTBOUND_PASSWORD(HttpStatus.BAD_REQUEST, "400_2", "영문 & 숫자 & 특수기호 포함 8자 이상 20자 이하로 가능합니다."),
    OUTBOUND_NICKNAME(HttpStatus.BAD_REQUEST, "400_3", "영문 & 숫자 포함 3자 이상 10자 이하로 가능합니다."),

    // 404 Not Found
    NOT_FOUND_PRODUCT(HttpStatus.NOT_FOUND, "404_1", "해당 관심상품 아이디가 존재하지 않습니다."),
    NOT_FOUND_FOLDER(HttpStatus.NOT_FOUND, "404_2", "해당 폴더 아이디가 존재하지 않습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

    ErrorCode(HttpStatus httpStatus, String errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
