package com.wai.controller.dto;

import com.wai.domain.user.Gender;
import lombok.*;

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
