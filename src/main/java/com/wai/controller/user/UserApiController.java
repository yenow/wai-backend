package com.wai.controller.user;

import com.wai.common.exception.ApiException;
import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.controller.user.dto.UserRequestDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    final UserService userService;

    @PostMapping(value = "/saveUserKey")
    public ResponseEntity<Long> saveUserKey(@RequestBody UserRequestDto userRequestDto) {
        Long userId = userService.saveUserKey(userRequestDto.getUserKey());
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/getUserInformation")
    public UserDto getUserInformation(@RequestBody UserRequestDto userRequestDto) {
        if (StringUtils.isEmpty(userRequestDto.getUserKey())) throw new UserKeyNotExistException();

        return userService.getUserInformation(userRequestDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/saveNickname")
    public UserDto saveNickname(@RequestBody UserRequestDto userRequestDto) {
        UserDto userDto = userService.saveNickname(userRequestDto);
        return userDto;
    }
}
