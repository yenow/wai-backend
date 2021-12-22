package com.wai.controller.dto;

import lombok.*;

/**
 * packageName : com.wai.controller.dto
 * fileName : LoginRequestDto
 * author : 윤신영
 * date : 2021-12-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-22   윤신영     최초 생성
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class LoginResponseDto {

    private Boolean isLoginSuccess;
    private Boolean isErrorMessage;
    private String errorMessage;

    @Builder
    public LoginResponseDto(Boolean isLoginSuccess, Boolean isErrorMessage, String errorMessage) {
        this.isLoginSuccess = isLoginSuccess;
        this.isErrorMessage = isErrorMessage;
        this.errorMessage = errorMessage;
    }
}
