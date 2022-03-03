package com.wai.service.user;

import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.common.exception.user.UserKeyTooLongException;
import com.wai.common.exception.user.UserNicknameDuplicationException;
import com.wai.controller.enneagramTest.dto.EnneagramTestDto;
import com.wai.controller.user.dto.UserRequestDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    final UserRepository userRepository;
    final ModelMapper modelMapper;

    @Transactional
    public UserDto getUserInformation(UserRequestDto userRequestDto) {
        User user = userRepository.getUserInformation(userRequestDto).orElse(User.builder().build());

        List<EnneagramTestDto> enneagramTests = user.getUserEnneagramTests().stream()
                .map(userEnneagramTest -> userEnneagramTest.getEnneagramTest().toDto())
                .collect(Collectors.toList());

        return user.toDto()
                .setPostDtos(user.getPosts())
                .setReplyDtos(user.getReplys())
                .setEnneagramTestDtos(enneagramTests);
    }

    private UserDto convertUserToUserResponseDto(User user) {
        UserDto userDto = user.toDto();
        userDto.setPosts(user.getPostDtos());
        return UserDto.builder().build();
    }

    @Transactional
    public UserDto saveNickname(UserRequestDto userRequestDto) {
        if (isNicknameDuplicated(userRequestDto)) throw new UserNicknameDuplicationException();

        User user = userRepository.findById(userRequestDto.getUserId()).get();
        user.saveNickname(userRequestDto.getNickname());

        return user.toDto();
    }

    private boolean isNicknameDuplicated(UserRequestDto userRequestDto) {
        return userRepository.findByNickname(userRequestDto.getNickname()).isPresent();
    }

    public Long saveUserKey(String userKey) {
        if (StringUtils.isBlank(userKey)) {
            throw new UserKeyNotExistException();
        } else if (userKey.getBytes(StandardCharsets.UTF_8).length > 200) {
            throw new UserKeyTooLongException();
        }

        return userRepository.save(User.builder().userKey(userKey).build()).getUserId();
    }
}
