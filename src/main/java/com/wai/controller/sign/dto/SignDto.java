package com.wai.controller.sign.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignDto {
    private String token;
    private Long userId;
    private String userKey;
    private String email;
    private String password;
}
