package com.wai.service.login;

import com.wai.WaiSpringApplication;
import com.wai.controller.dto.login.LoginRequestDto;
import com.wai.controller.dto.login.LoginResponseDto;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * packageName : com.wai.service.login
 * fileName : LoginServiceImplTest
 * author : 윤신영
 * date : 2021-12-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-22   윤신영     최초 생성
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= WaiSpringApplication.class)
class LoginServiceImplTest {

    @Autowired
    LoginService loginService;

    @Autowired
    UserRepository userRepository;

    /******************************************************************************************/

    @BeforeEach
    public void setUp() {
        // given
        User user = User.builder()
                .nickname("nickname")
                .password("password")
                .phoneNumber("01021245690")
                .build();

        userRepository.save(user);
    }

    @AfterEach
    public void cleanup() {
        userRepository.deleteAll();
    }

    /******************************************************************************************/

    @DisplayName("id가 틀림")
    @Test
    public void notSameIdCheck() throws Exception {
        // given
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        MockHttpSession session = new MockHttpSession();
        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .id("01021245691")
                .password("password")
                .build();

        // when
        loginService.checkLogin(loginRequestDto, loginResponseDto, session);

        // then
        assertThat(loginResponseDto.getIsLoginSuccess(), is(false));
        assertThat(loginResponseDto.getIsErrorMessage(), is(true));
        System.out.println(loginResponseDto.getErrorMessage());
    }

    @DisplayName("비밀번호가 틀림")
    @Test
    public void notSamePasswordCheck() {
        // given
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        MockHttpSession session = new MockHttpSession();
        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .id("01021245690")
                .password("password1")
                .build();

        // when
        loginService.checkLogin(loginRequestDto, loginResponseDto, session);

        // then
        assertThat(loginResponseDto.getIsLoginSuccess(), is(false));
        assertThat(loginResponseDto.getIsErrorMessage(), is(true));
        System.out.println(loginResponseDto.getErrorMessage());
    }

    @DisplayName("성공")
    @Test
    public void success() {
        // given
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        MockHttpSession session = new MockHttpSession();
        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .id("01021245690")
                .password("password")
                .build();

        // when
        loginService.checkLogin(loginRequestDto, loginResponseDto, session);

        // then
        assertThat(loginResponseDto.getIsLoginSuccess(), is(true));
        assertThat(loginResponseDto.getIsErrorMessage(), is(false));
        System.out.println(loginResponseDto.getErrorMessage());
    }
}