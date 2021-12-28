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
public class SimpleLoginRequestDto {

    private String loginKey;
    private String nickname;
    private String birthday;
    private Gender gender;

    @Builder
    public SimpleLoginRequestDto(String loginKey, String nickname, String birthday, Gender gender) {
        this.loginKey = loginKey;
        this.nickname = nickname;
        this.birthday = birthday;
        this.gender = gender;
    }
}
