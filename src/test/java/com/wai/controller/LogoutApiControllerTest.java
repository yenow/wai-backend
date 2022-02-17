package com.wai.controller;

import com.wai.controller.logout.dto.LogoutResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LogoutApiControllerTest {

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