package com.wai.service.user;

import com.wai.controller.user.dto.UserRequestDto;
import com.wai.controller.user.dto.UserResponseDto;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;

/**
 * packageName : com.wai.service.post
 * fileName : UserService
 * author : 윤신영
 * date : 2021-12-20
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-20   윤신영     최초 생성
 */
@RequiredArgsConstructor
@Service
public class UserService {

    final UserRepository userRepository;

    public User getUserInfomation(UserRequestDto userRequestDto) {
        return userRepository.findById(userRequestDto.getUserId()).get();
    }

    @Transactional
    public UserResponseDto saveNickname(UserRequestDto userRequestDto) {
        UserResponseDto userDto = UserResponseDto.builder().build();

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
