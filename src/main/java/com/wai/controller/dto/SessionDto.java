package com.wai.controller.dto;

import com.wai.domain.user.User;
import lombok.*;

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
