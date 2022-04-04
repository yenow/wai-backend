package com.wai.domain.userBan;

import com.wai.dto.banUser.BanUserDto;
import com.wai.dto.banUser.BanUserRequestDto;

import java.util.List;
import java.util.Optional;

public interface BanUserCustomRepository {
    List<BanUserDto> getBanUsers(Long userId);

    void deleteBanUser(BanUserRequestDto banUserRequestDto);

    Optional<BanUser> findByUserIdAndBanUserId(BanUserRequestDto banUserRequestDto);
}
