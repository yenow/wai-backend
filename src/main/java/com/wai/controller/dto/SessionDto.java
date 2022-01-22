package com.wai.controller.dto;

import com.wai.domain.user.User;
import lombok.*;

/**
 * packageName : com.wai.controller.dto
 * fileName : SessionDto
 * author : 윤신영
 * date : 2021-12-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-22   윤신영     최초 생성
 */
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto {

    private Long userId;
    private String password;
    private String email;
    private String phoneNumber;
    private String nickname;
    private String birthDay;

    public void setSessionByUser (User user) {
        this.userId = user.getUserId();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.nickname = user.getNickname();
        this.birthDay = user.getBirthDay();
    }
}
