package com.wai.dto.user;

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
