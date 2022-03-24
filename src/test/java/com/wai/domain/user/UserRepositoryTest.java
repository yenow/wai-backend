package com.wai.domain.user;

import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.dto.enneagramTest.EnneagramTestDto;
import com.wai.dto.user.UserRequestDto;
import com.wai.dto.user.UserDto;
import com.wai.dummyData.DummyData;
import com.wai.dummyData.DummyUser;
import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DummyUser dummyUser;

    List<User> users;
    User user;

    @BeforeAll
    void beforeAll() {
    }

    @BeforeEach
    void beforeEach() {
        users = dummyUser.createDummyUsers();
        System.out.println("=== start test ===");
    }

    @AfterEach
    void afterEach() {
        if (user != null) {
            userRepository.delete(user);
        }
        System.out.println("=== end test ===");
    }

    @Transactional
    @Test
    void getUserInformation() {
        // given
        User user = users.get(0);

        // when
        User findUser = userRepository.getUserInformation(
                UserRequestDto.builder().userKey(user.getUserKey()).build()
        ).orElse(User.builder().build());

        // then
        /*UserDto userDto = modelMapper.map(findUser, UserDto.class);*/
        UserDto userDto = new UserDto(findUser);

        System.out.println("userDto = " + userDto);
        assertThat(findUser.getUserEnneagramTests()).isNotNull();
        assertThat(findUser.getUserEnneagramTests().size()).isNotEqualTo(0);
        assertThat(findUser.getUserId()).isEqualTo(userDto.getUserId());
        assertThat(findUser.getUserEnneagramTests().get(0).getId()).isGreaterThan(findUser.getUserEnneagramTests().get(1).getId());

    }

    @Transactional
    @Test
    void getUserDtoInformation() {
        // given
        User user = users.get(0);

        // when
        UserDto findUserDto = userRepository.getUserDtoInformation(
                UserRequestDto.builder().userKey(user.getUserKey()).build()
        ).orElse(UserDto.builder().build());

        // then
        System.out.println("userResponseDto = " + findUserDto);
    }
    
    @DisplayName("유저의 에니어그램테스트 리스트 가져오기")
    @Test
    void getUserEnneagramTests() {
        // given
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .userId(users.get(3).getUserId())
                .userKey(users.get(3).getUserKey())
                .build();

        // when
        List<EnneagramTest> enneagramTests = userRepository.getUserEnneagramTests(userRequestDto.getUserKey());
        
        // then
        assertThat(enneagramTests.size()).isEqualTo(0);
    }
}