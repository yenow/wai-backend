package com.wai.controller.user;

import com.wai.common.exception.ApiException;
import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.controller.user.dto.UserRequestDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    final UserService userService;

    @PostMapping(value = "/api/saveUserKey")
    public ResponseEntity<Long> saveUserKey(@RequestBody UserRequestDto userRequestDto) {
        Long userId = userService.saveUserKey(userRequestDto.getUserKey());
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

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
