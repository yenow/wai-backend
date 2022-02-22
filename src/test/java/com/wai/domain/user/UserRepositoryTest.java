package com.wai.domain.user;

import com.wai.controller.login.dto.LoginRequestDto;
import com.wai.dummyData.DummyData;
import com.wai.testConfig.TestConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired UserRepository userRepository;
    @Autowired DummyData dummyData;

    User user;

    @BeforeEach
    public void beforeEach() {
        dummyData.initUsers();
    }

    @AfterEach
    public void afterEach() {
        if (user != null) {
            userRepository.delete(user);
        }
    }

    @DisplayName("findByEmail() 테스트")
    @Test
    public void findByEmail() {
        // given
        user = User.builder().userKey(UUID.randomUUID().toString()).nickname("nickname").password("password").email("email")
                .build();

        LoginRequestDto loginRequestDto = LoginRequestDto.builder().id("email").password("password").build();

        // when
        userRepository.save(user);
        User findUser = userRepository.findByEmail(loginRequestDto.getId());

        // then
        assertThat(findUser.getEmail()).isEqualTo(loginRequestDto.getId());
    }

    @DisplayName("findByUserKey() 테스트")
    @Test
    public void findByUserKey() {
        // given
        String userKey = UUID.randomUUID().toString();
        user = User.builder().nickname("nickname").userKey(userKey).password("password").email("email").build();

        // when
        userRepository.save(user);
        User findUser = userRepository.findByUserKey(userKey).get();

        // then
        assertThat(findUser.getUserKey()).isEqualTo(user.getUserKey());
    }

    @Test
    void testFindByNickname() {
        // given
        String userKey = UUID.randomUUID().toString();
        user = User.builder().nickname("nickname").userKey(userKey).build();

        // when
        userRepository.save(user);
        User findUser = userRepository.findByNickname(user.getNickname())
                .orElse(User.builder().build());

        // then
        Assertions.assertThat(findUser.getNickname()).isEqualTo(user.getNickname());
    }
}