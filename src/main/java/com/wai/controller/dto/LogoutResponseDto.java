package com.wai.controller.dto;

import lombok.*;

/**
 * packageName : com.wai.controller.dto
 * fileName : LogoutResponseDto
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
public class LogoutResponseDto {

    private Boolean isLogoutSuccess;
    private Boolean isErrorMessage;
    private String errorMessage;

    @Builder
    public LogoutResponseDto(Boolean isLoginSuccess, Boolean isErrorMessage, String errorMessage) {
        this.isLogoutSuccess = isLoginSuccess;
        this.isErrorMessage = isErrorMessage;
        this.errorMessage = errorMessage;
    }
}
