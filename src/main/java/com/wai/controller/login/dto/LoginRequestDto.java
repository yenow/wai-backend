package com.wai.controller.login.dto;

import lombok.*;

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
