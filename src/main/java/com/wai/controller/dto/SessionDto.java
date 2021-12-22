package com.wai.controller.dto;

import com.wai.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class SessionDto {

    private Long userId;
    private String password;
    private String email;
    private String phoneNumber;
    private String nickname;
    private String birthDay;

    @Builder
    public SessionDto(Long userId, String password, String email, String phoneNumber, String nickname, String birthDay) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.birthDay = birthDay;
    }

    public void setSessionByUser (User user) {
        this.userId = user.getUserId();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.nickname = user.getNickname();
        this.birthDay = user.getBirthDay();
    }
}
