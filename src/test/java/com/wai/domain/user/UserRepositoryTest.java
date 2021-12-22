package com.wai.domain.user;

import com.wai.controller.dto.LoginRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

/**
 * packageName : com.wai.domain.user
 * fileName : UserRepositoryTest
 * author : 윤신영
 * date : 2021-12-21
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-21   윤신영     최초 생성
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception{
        userRepository.deleteAll();
    }

    @After
    public void cleanup() {
        userRepository.deleteAll();
    }

    @DisplayName("findAllByPhoneNumber() 테스트")
    @Test
    public void findAllByPhoneNumber() {
        // given
        User user = User.builder()
                .nickname("nickname")
                .password("password")
                .phoneNumber("01021245690")
                .birthDay("birthDay")
                .build();

        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .id("01021245690")
                .password("password")
                .build();

        // when
        userRepository.save(user);
        User findUser = userRepository.findByPhoneNumber(loginRequestDto.getId());

        // then
        assertNotNull(findUser);
        assertThat(findUser.getPhoneNumber(), is(loginRequestDto.getId()));
    }

    @DisplayName("findAllByEmail() 테스트")
    @Test
    public void findAllByEmail() {
        // given
        User user = User.builder()
                .nickname("nickname")
                .password("password")
                .email("email")
                .birthDay("birthDay")
                .build();

        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .id("email")
                .password("password")
                .build();

        // when
        userRepository.save(user);
        User findUser = userRepository.findByEmail(loginRequestDto.getId());

        // then
        assertNotNull(findUser);
        assertThat(findUser.getEmail(), is(loginRequestDto.getId()));
    }
}