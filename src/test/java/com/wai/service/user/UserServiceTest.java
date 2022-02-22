package com.wai.service.user;

import com.wai.controller.user.dto.UserRequestDto;
import com.wai.controller.user.dto.UserResponseDto;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(properties = "spring.config.location=classpath:application-test.properties")
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    String userKey;
    User user;

    @BeforeEach
    void before() {

        userKey = UUID.randomUUID().toString();
        System.out.println(userKey);
        userRepository.deleteByUserKey(userKey);

        user = User.builder().userKey(userKey).build();
        userRepository.save(user);
        System.out.println("==== end before() method ====");
    }

    @AfterEach
    void after () {
        System.out.println("==== start after() method ====");
        userRepository.deleteByUserKey(userKey);
    }

    @Test
    void getUserInformation () {
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .userId(user.getUserId())
                .userKey(userKey)
                .build();

        UserResponseDto actualUser = userService.getUserInformation(userRequestDto);

        System.out.println(actualUser.getUserId());
        assertEquals(user.getUserId(), actualUser.getUserId());

    }
}