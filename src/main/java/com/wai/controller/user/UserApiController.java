package com.wai.controller.user;

import com.wai.controller.enneagramTest.dto.EnneagramTestResponseDto;
import com.wai.controller.user.dto.UserRequestDto;
import com.wai.controller.user.dto.UserResponseDto;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.user.User;
import com.wai.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    final UserService userService;

    @PostMapping(value = "/api/getUserInformation")
    public UserResponseDto getUserInformation(@RequestBody UserRequestDto userRequestDto) {
        return userService.getUserInformation(userRequestDto);
    }

    @PostMapping(value = "/api/saveNickname")
    public UserResponseDto saveNickname(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userDto = userService.saveNickname(userRequestDto);
        return userDto;
    }
}
