package com.wai.controller.user;

import com.wai.controller.user.dto.UserRequestDto;
import com.wai.controller.user.dto.UserResponseDto;
import com.wai.domain.user.User;
import com.wai.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * packageName : com.wai.controller.user
 * fileName : UserApiController
 * author : 윤신영
 * date : 2022-01-24
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-24   윤신영     최초 생성
 */
@RequiredArgsConstructor
@RestController
public class UserApiController {

    final UserService userService;

    @PostMapping(value = "/api/getUserInfomation")
    public UserResponseDto getUserInfomation(@RequestBody UserRequestDto userRequestDto) {
        User user = userService.getUserInfomation(userRequestDto);

        return user.toDto()
                .setPostDtos(user.getPosts().stream().map(post -> post.toDto()).collect(Collectors.toList()))
                .setReplyDtos(user.getReplys().stream().map(reply -> reply.toDto()).collect(Collectors.toList()));
    }

}
