package com.wai.service.user;

import com.wai.controller.user.dto.UserRequestDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.domain.user.User;
import com.wai.dummyData.DummyData;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    DummyData dummyData;

    @BeforeAll
    void beforeAll() {
        dummyData.initUsers();
        dummyData.initUserEnneagramTests();
        dummyData.initPosts();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("==== start Test ====");
    }

    @AfterEach
    void afterEach () {
        System.out.println("==== End Test ====");
    }

    @Transactional
    @Test
    void getUserInformation () {
        // given
        User user = dummyData.getUsers().get(0);
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .userKey(user.getUserKey())
                .build();

        // when
        UserDto findUser = userService.getUserInformation(userRequestDto);

        // then
        System.out.println(findUser);
        System.out.println("==========");
        System.out.println(findUser.getPosts());
        System.out.println("==========");
        System.out.println(findUser.getEnneagramTests());
        assertEquals(user.getUserId(), findUser.getUserId());

    }
}