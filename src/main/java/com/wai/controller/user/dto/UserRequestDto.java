package com.wai.controller.user.dto;

import lombok.*;


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
