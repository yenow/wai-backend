package com.wai.controller;

import com.wai.common.exception.user.UserNicknameNotExistException;
import com.wai.common.exception.user.UserIdNotExistException;
import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.dto.enneagramTest.EnneagramTestDto;
import com.wai.dto.user.UserRequestDto;
import com.wai.dto.user.UserDto;
import com.wai.service.user.UserService;
import com.wai.service.user.UserServiceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    final UserService userService;
    final UserServiceUtil userServiceUtil;


    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/getUserInformation")
    public UserDto getUserInformation(@RequestBody UserRequestDto userRequestDto) {
        if (userRequestDto.getUserId() == null) throw new UserIdNotExistException();
        if (StringUtils.isEmpty(userRequestDto.getUserKey())) throw new UserKeyNotExistException();

        return userService.getUserInformation(userRequestDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/getUserEnneagramTests")
    public List<EnneagramTestDto> getUserEnneagramTests(@RequestBody UserRequestDto userRequestDto) {
        if (StringUtils.isEmpty(userRequestDto.getUserKey())) throw new UserKeyNotExistException();

        return userService.getUserEnneagramTests(userRequestDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PatchMapping("/update")
    public UserDto updateUser(@RequestParam("userId") String userId,@RequestParam("userKey") String userKey,@RequestParam("nickname") String nickname
        ,@RequestPart("imageFile") MultipartFile multipartFile) {
        if (StringUtils.isEmpty(userId)) throw new UserIdNotExistException();
        if (StringUtils.isEmpty(userKey)) throw new UserKeyNotExistException();
        if (StringUtils.isEmpty(nickname)) throw new UserNicknameNotExistException();


        UserRequestDto userRequestDto = UserRequestDto.builder()
                .userId(Long.parseLong(userId))
                .userKey(userKey)
                .nickname(nickname)
                .build();

        log.info("userId: {} {}", userRequestDto.getUserId(), userId);
        log.info("multipartFile: {} {} {} {}", multipartFile.getName(), multipartFile.isEmpty(), multipartFile.getOriginalFilename(), multipartFile.getContentType());
        // todo image size 줄이기

        return userService.updateUser(userRequestDto, multipartFile);
    }




    /*  deprecated */
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/saveUserKey")
    public ResponseEntity<Long> saveUserKey(@RequestBody UserRequestDto userRequestDto) {
        Long userId = userService.saveUserKey(userRequestDto.getUserKey());
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    /*  deprecated */
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/saveNickname")
    public UserDto saveNickname(@RequestBody UserRequestDto userRequestDto) {
        UserDto userDto = userService.saveNickname(userRequestDto);
        return userDto;
    }
}
