package com.wai.service;

import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import com.wai.domain.userBan.BanUser;
import com.wai.domain.userBan.BanUserRepository;
import com.wai.domain.wiseSaying.WiseSaying;
import com.wai.domain.wiseSaying.WiseSayingRepository;
import com.wai.dto.banUser.BanUserDto;
import com.wai.dto.banUser.BanUserRequestDto;
import com.wai.dto.wiseSaying.WiseSayingRequestDto;
import com.wai.dto.wiseSaying.WiseSayingResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BanUserService {

    final private BanUserRepository banUserRepository;
    final private UserRepository userRepository;

    @Transactional
    public BanUserDto createBanUser(BanUserRequestDto banUserRequestDto) {
        // todo. 예외처리
        if (banUserRequestDto.getUserId() == null) throw new RuntimeException();
        if (banUserRequestDto.getBanUserId() == null) throw new RuntimeException();

        Optional<BanUser> findBanUser = banUserRepository.findByUserIdAndBanUserId(banUserRequestDto);

        if (!findBanUser.isPresent()) {
            User user = userRepository.findById(banUserRequestDto.getUserId()).orElseThrow();
            User banUser = userRepository.findById(banUserRequestDto.getBanUserId()).orElseThrow();

            BanUser saveBanUser = banUserRepository.save(BanUser.builder()
                    .user(user)
                    .banUser(banUser)
                    .build());
            return new BanUserDto(saveBanUser);
        }

        return new BanUserDto(findBanUser.get());
    }

    public List<BanUserDto> getBanUsers(Long userId) {
        if (userId == null) throw new RuntimeException();
        return banUserRepository.getBanUsers(userId);
    }

    @Transactional
    public BanUserDto deleteBanUser(BanUserRequestDto banUserRequestDto) {
        if (banUserRequestDto.getUserId() == null) throw new RuntimeException();
        banUserRepository.deleteBanUser(banUserRequestDto);
        return BanUserDto.builder()
                .userId(banUserRequestDto.getUserId())
                .banUserId(banUserRequestDto.getBanUserId())
                .build();
    }
}
