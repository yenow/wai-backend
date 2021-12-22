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
public class LoginRequestDto {

    private String id;
    private String password;

    @Builder
    public LoginRequestDto(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
