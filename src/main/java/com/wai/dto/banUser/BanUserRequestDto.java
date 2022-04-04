package com.wai.dto.banUser;

import com.wai.domain.user.User;
import com.wai.domain.userBan.BanUser;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BanUserRequestDto {
    private Long userId;
    private Long banUserId;
}
