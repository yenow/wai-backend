package com.wai.controller.login.dto;

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
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

    private Boolean isLoginSuccess;
    private Boolean isErrorMessage;
    private String errorMessage;
}
