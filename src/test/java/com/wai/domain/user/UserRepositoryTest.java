package com.wai.domain.user;

import com.wai.controller.user.dto.UserRequestDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.dummyData.DummyData;
import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserRepositoryTest {

    @Autowired UserRepository userRepository;
    @Autowired DummyData dummyData;
    @Autowired ModelMapper modelMapper;
    @PersistenceUnit EntityManagerFactory entityManagerFactory;

    User user;

    @BeforeAll
    void beforeAll() {
        dummyData.initUsers();
        dummyData.initUserEnneagramTests();
        dummyData.initPosts();
    }

    @BeforeEach
    void beforeEach() {
        dummyData.initUsers();
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
        User user = dummyData.getUsers().get(0);

        // when
        User findUser = userRepository.getUserInformation(
                UserRequestDto.builder().userKey(user.getUserKey()).build()
        ).orElse(User.builder().build());

        // then
        UserDto userDto = modelMapper.map(findUser, UserDto.class);

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
        User user = dummyData.getUsers().get(0);

        // when
        UserDto findUserDto = userRepository.getUserDtoInformation(
                UserRequestDto.builder().userKey(user.getUserKey()).build()
        ).orElse(UserDto.builder().build());

        // then
        System.out.println("userResponseDto = " + findUserDto);
    }
}