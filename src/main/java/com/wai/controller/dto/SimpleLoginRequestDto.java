package com.wai.controller.dto;

import com.wai.domain.user.Gender;
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
@AllArgsConstructor
public class SimpleLoginRequestDto {

    private String userKey;
    private String nickname;
    private String birthday;
    private Gender gender;
}
