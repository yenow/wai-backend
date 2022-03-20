package com.wai.service.user;

import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.user.UserRepository;
import com.wai.dto.enneagramTest.EnneagramTestDto;
import com.wai.dto.user.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceUtil {
    final UserRepository userRepository;

    public boolean isNicknameDuplicated(UserRequestDto userRequestDto) {
        return userRepository.findByNicknameAndNotUserId(userRequestDto).isPresent();
    }

    public List<EnneagramTestDto> getUserEnneagramTests(UserRequestDto userRequestDto) {
        List<EnneagramTest> enneagramTests = userRepository.getUserEnneagramTests(userRequestDto.getUserKey());
        return enneagramTests.stream().map(EnneagramTestDto::new).collect(Collectors.toList());
    }
}
