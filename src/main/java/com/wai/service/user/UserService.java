package com.wai.service.user;

import com.wai.controller.enneagramTest.dto.EnneagramTestDto;
import com.wai.controller.user.dto.UserRequestDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    final UserRepository userRepository;

    @Transactional
    public UserDto getUserInformation(UserRequestDto userRequestDto) {
        User user = userRepository.findByUserKey(userRequestDto.getUserKey()).orElse(User.builder().build());

        List<EnneagramTestDto> enneagramTests = user.getUserEnneagramTests().stream()
                .map(userEnneagramTest -> userEnneagramTest.getEnneagramTest().toDto())
                .collect(Collectors.toList());

        Collections.reverse(enneagramTests);

        return user.toDto()
                .setPostDtos(user.getPostDtos())
                .setReplyDtos(user.getReplyDtos())
                .setEnneagramTestDtos(enneagramTests);
    }

    private UserDto convertUserToUserResponseDto(User user) {
        UserDto userDto = user.toDto();
        userDto.setPosts(user.getPostDtos());
        return UserDto.builder().build();
    }

    @Transactional
    public UserDto saveNickname(UserRequestDto userRequestDto) {
        UserDto userDto = UserDto.builder().build();

        if (isNicknameDupicated(userRequestDto)) {
            userDto.setIsSuccess(false);
            userDto.setErrorCode(1);
            userDto.setErrorMessage("이미 사용중인 별명입니다.");
        } else {
            User user = userRepository.findById(userRequestDto.getUserId()).get();
            user.saveNickname(userRequestDto.getNickname());
        }

        return userDto;
    }

    private boolean isNicknameDupicated(UserRequestDto userRequestDto) {
        return userRepository.findByNickname(userRequestDto.getNickname()).isPresent();
    }
}
