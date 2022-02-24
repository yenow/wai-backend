package com.wai.controller.user;

import com.wai.controller.user.dto.UserRequestDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    final UserService userService;

    @PostMapping(value = "/api/getUserInformation")
    public UserDto getUserInformation(@RequestBody UserRequestDto userRequestDto) {
        return userService.getUserInformation(userRequestDto);
    }

    @PostMapping(value = "/api/saveNickname")
    public UserDto saveNickname(@RequestBody UserRequestDto userRequestDto) {
        UserDto userDto = userService.saveNickname(userRequestDto);
        return userDto;
    }
}
