package com.wai.controller.dto.login;

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
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {

    private String userKey;
    private String id;
    private String password;
}
