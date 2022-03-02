package com.wai.service.user;

import com.wai.common.util.Utility;
import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.common.exception.user.UserKeyTooLongException;
import com.wai.controller.user.dto.UserRequestDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.domain.user.User;
import com.wai.dummyData.DummyData;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DummyData dummyData;

    @Autowired
    private Utility utility;

    @BeforeAll
    static void beforeAll() {
    }

    @BeforeEach
    void beforeEach() {
//        dummyData.initUsers();
//        dummyData.initUserEnneagramTests();
//        dummyData.initPosts();
        System.out.println("==== start Test ====");
    }

    @AfterEach
    void afterEach () {
        System.out.println("==== End Test ====");
    }

    @Test   
    @DisplayName("saveUserKey 테스트")
    void saveUserKey() {
        // given
        List<String> userKeys = new ArrayList<>(
            Arrays.asList(
                ""
                ,UUID.randomUUID().toString()
                ,utility.getRandomString(200)
                ,utility.getRandomString(201)
            )
        );
        // when

        // then
        assertSaveUserKey(userKeys);
    }

    void assertSaveUserKey(List<String> userKeys) {
        for (String userKey : userKeys) {
            int index = userKeys.indexOf(userKey);
            Long userId;

            switch (index) {
                case 0 :
                    assertThatThrownBy(() -> userService.saveUserKey(userKeys.get(index))).isInstanceOf(UserKeyNotExistException.class);
                    break;
                case  1 :
                    userId =  userService.saveUserKey(userKeys.get(index));
                    assertThat(userId).isNotNull();
                    break;
                case  2 :
                    userId =  userService.saveUserKey(userKeys.get(index));
                    System.out.println(userKeys.get(index));
                    assertThat(userId).isNotNull();
                    break;
                case   3 :
                    assertThatThrownBy(() -> userService.saveUserKey(userKeys.get(index))).isInstanceOf(UserKeyTooLongException.class);
                    break;
            }
        }
    }
    
    @Test
    void getUserInformation () {
        // given
        User user = dummyData.getUsers().get(0);
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .userKey(user.getUserKey())
                .build();

        // when
        UserDto findUserDto = userService.getUserInformation(userRequestDto);

        // then
        assertThat(findUserDto.getPosts().size()).isGreaterThan(0);
        assertThat(findUserDto.getEnneagramTests().size()).isGreaterThan(0);
        assertThat(findUserDto.getEnneagramTests().get(0).getTestId()).isGreaterThan(findUserDto.getEnneagramTests().get(1).getTestId());
    }

    @Test
    void saveNickname() {
        // given
        User user = dummyData.getUsers().get(0);
        User user2 = dummyData.getUsers().get(1);
        UserRequestDto duplicateUser = UserRequestDto.builder()
                .userId(user.getUserId())
                .userKey(user.getUserKey())
                .nickname("nickname1")
                .build();
        UserRequestDto non_duplicateUser = UserRequestDto.builder()
                .userId(user2.getUserId())
                .userKey(user2.getUserKey())
                .nickname("non_duplicate_nickname")
                .build();

        // when
        UserDto userDto = userService.saveNickname(duplicateUser);
        UserDto userDto2 = userService.saveNickname(non_duplicateUser);

        // then
        assertThat(userDto.getErrorCode()).isEqualTo(1);
        assertThat(userDto2.getNickname()).isEqualTo(non_duplicateUser.getNickname());

    }
}