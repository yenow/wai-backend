package com.wai.dto.banUser;

import com.wai.domain.userBan.BanUser;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BanUserDto {
    private Long userId;
    private Long banUserId;
    private String banNickname;

    public BanUserDto(BanUser banUser) {
        this.userId = banUser.getUser().getUserId();
        this.banUserId = banUser.getBanUser().getUserId();
        this.banNickname = banUser.getBanUser().getNickname();
    }
}
