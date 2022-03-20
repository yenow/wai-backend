package com.wai.service.user;

import com.wai.common.util.Utility;
import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.common.exception.user.UserKeyTooLongException;
import com.wai.dto.enneagramTest.EnneagramTestDto;
import com.wai.dto.user.UserRequestDto;
import com.wai.dto.user.UserDto;
import com.wai.domain.user.User;
import com.wai.dummyData.DummyUser;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DummyUser dummyUser;
    @Autowired
    private Utility utility;

    List<User> users = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
    }

    @BeforeEach
    void beforeEach() {
        users = dummyUser.createDummyUsers();

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
        User user = users.get(0);
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
        User user = users.get(0);
        User user2 = users.get(1);
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
        assertThat(userDto2.getNickname()).isEqualTo(non_duplicateUser.getNickname());
    }

    @DisplayName("유저의 에니어그램 테스트 목록 가져오기")
    @Test
    void getUserEnneagramTests() {
        // given
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .userId(users.get(3).getUserId())
                .userKey(users.get(3).getUserKey())
                .build();

        // when
        List<EnneagramTestDto> enneagramTests = userService.getUserEnneagramTests(userRequestDto);

        // then
    }

    @DisplayName("유저정보 업데이트")
    @Test
    void updateUser() throws IOException {
        // given
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .userId(users.get(0).getUserId())
                .userKey(users.get(0).getUserKey())
                .nickname(users.get(0).getNickname())
                .build();

        // when
        UserDto userDto = userService.updateUser(userRequestDto, null);

        // then
        System.out.println("userDto = " + userDto);
        assertThat(userDto.getNickname()).isEqualTo(userRequestDto.getNickname());
    }

    @DisplayName("유저정보 업데이트2")
    @Test
    void updateUser2() throws IOException {
        // given
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .userId(users.get(0).getUserId())
                .userKey(users.get(0).getUserKey())
                .nickname("newNickname")
                .build();

        // when
        UserDto userDto = userService.updateUser(userRequestDto, null);

        // then
        System.out.println("userDto = " + userDto);
        assertThat(userDto.getNickname()).isEqualTo(userRequestDto.getNickname());
    }




    private MockMultipartFile getMockMultipartFile(String fileName, String contentType, String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        return new MockMultipartFile(fileName, fileName + "." + contentType, contentType, fileInputStream);
    }

    @Test
    @DisplayName("MockMultipartFile 동작 테스트")
    public void getMockExcelUploadTest() throws IOException {
        /*MockMultipartHttpServletRequest multipartHttpServletRequest = new MockMultipartHttpServletRequest();*/ // controller test 시 사용
        String fileName = "test";
        String contentType = "png";
        String filePath = "src/test/resources/image/test.png";
        MockMultipartFile mockMultipartFile = getMockMultipartFile(fileName, contentType, filePath);

        String getFileName = mockMultipartFile.getOriginalFilename().toLowerCase();

        assertThat(getFileName).isEqualTo(fileName.toLowerCase() + "." + contentType);
    }


}