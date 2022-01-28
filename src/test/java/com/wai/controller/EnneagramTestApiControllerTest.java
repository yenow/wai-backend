package com.wai.controller;

import com.wai.controller.enneagramTest.dto.EnneagramTestRequestDto;
import com.wai.domain.enneagramTest.EnneagramTestRepository;
import com.wai.domain.enneagramTest.TestType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * packageName : com.wai.controller
 * fileName : EnneagramTestApiControllerTest
 * author : 윤신영
 * date : 2022-01-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-22   윤신영     최초 생성
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EnneagramTestApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EnneagramTestRepository enneagramTestRepository;

    @DisplayName("")
    @Test
    void saveEnneagramTest () {
        EnneagramTestRequestDto enneagramTestRequestDto = EnneagramTestRequestDto.builder()
                .testType(TestType.select)
                .myEnneagramType(1)
                .build();

    }
}