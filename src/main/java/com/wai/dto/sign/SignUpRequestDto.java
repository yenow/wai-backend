package com.wai.dto.sign;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {
    private String token;
    private String username;
    private String password;

    private String userKey;
    private String email;

    public void setUsername() {
        if (!StringUtils.isEmpty(email)) {
            username = email;
        } else if (!StringUtils.isEmpty(userKey)){
            username = userKey;
        }
    }
}
