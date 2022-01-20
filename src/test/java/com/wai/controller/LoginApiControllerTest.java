package com.wai.controller;

import com.wai.controller.dto.LogoutResponseDto;
import com.wai.controller.dto.SimpleLoginRequestDto;
import com.wai.domain.user.Gender;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : com.wai.controller
 * fileName : LoginApiControllerTest
 * author : 윤신영
 * date : 2021-12-27
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-27   윤신영     최초 생성
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoginApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @DisplayName("login Test")
    @Test
    public void logout() throws Exception {
        //given
        String baseUrl = "http://localhost:" + port + "/api/login";

        //when
        LogoutResponseDto responseEntity = restTemplate.getForObject(baseUrl,LogoutResponseDto.class);

        //then
        assertThat(responseEntity.getIsErrorMessage()).isEqualTo(true);
        assertThat(responseEntity.getIsLogoutSuccess()).isEqualTo(false);
    }

    @DisplayName("simpleLogin Test")
    @Test
    public void simpleLogin() {
        //given
        String baseUrl = "http://localhost:" + port + "/api/simpleLogin";
        SimpleLoginRequestDto simpleLoginRequestDto = SimpleLoginRequestDto.builder()
                .userKey(UUID.randomUUID().toString())
                .nickname("nickname")
                .birthday("19941129")
                .gender(Gender.man)
                .build();

        //when
        // SimpleLoginRequestDto responseEntity = restTemplate.getForObject(baseUrl,loginRequestDto,SimpleLoginRequestDto.class);
        ResponseEntity<SimpleLoginRequestDto> responseEntity = restTemplate.postForEntity(baseUrl, simpleLoginRequestDto, SimpleLoginRequestDto.class);

        User user = userRepository.findByUserKey(simpleLoginRequestDto.getUserKey());

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(user.getNickname()).isEqualTo(simpleLoginRequestDto.getNickname());
        assertThat(user.getGender()).isEqualTo(simpleLoginRequestDto.getGender());
        assertThat(user.getBirthDay()).isEqualTo(simpleLoginRequestDto.getBirthday());
    }
}