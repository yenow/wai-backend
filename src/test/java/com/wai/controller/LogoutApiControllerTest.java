package com.wai.controller;

import com.wai.controller.dto.LogoutResponseDto;
import com.wai.controller.dto.PostSaveRequestDto;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import org.junit.After;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : com.wai.controller
 * fileName : LogoutApiControllerTest
 * author : 윤신영
 * date : 2021-12-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-22   윤신영     최초 생성
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LogoutApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @DisplayName("logout Test")
    @Test
    public void logout() throws Exception {
        //given
        String baseUrl = "http://localhost:" + port + "/api/logout";

        //when
        LogoutResponseDto responseEntity = restTemplate.getForObject(baseUrl,LogoutResponseDto.class);

        //then
        assertThat(responseEntity.getIsErrorMessage()).isEqualTo(true);
        assertThat(responseEntity.getIsLogoutSuccess()).isEqualTo(false);
    }
}