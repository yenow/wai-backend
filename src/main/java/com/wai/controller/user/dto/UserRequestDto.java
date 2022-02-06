package com.wai.controller.user.dto;

import lombok.*;

/**
 * packageName : com.wai.controller.user.dto
 * fileName : UserRequestDto
 * author : 윤신영
 * date : 2022-01-30
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-30   윤신영     최초 생성
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private Long userId;
    private String userKey;
    private String nickname;
}
