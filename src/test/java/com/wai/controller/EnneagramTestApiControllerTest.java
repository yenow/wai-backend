package com.wai.controller;

import com.wai.dto.enneagramTest.EnneagramTestRequestDto;
import com.wai.domain.enneagramTest.EnneagramTestRepository;
import com.wai.domain.enneagramTest.TestType;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnneagramTestApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EnneagramTestRepository enneagramTestRepository;

    @DisplayName("")
    @Test
    public void saveEnneagramTest () {
        EnneagramTestRequestDto enneagramTestRequestDto = EnneagramTestRequestDto.builder()
                .testType(TestType.select)
                .myEnneagramType(1)
                .build();

    }
}