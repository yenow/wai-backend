package com.wai.service.enneagramTest;

import com.wai.WaiSpringApplication;
import com.wai.controller.dto.enneagramTest.EnneagramTestRequestDto;
import com.wai.domain.enneagramTest.TestType;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : com.wai.service.enneagramTest
 * fileName : EnneagramTestServiceTest
 * author : 윤신영
 * date : 2022-01-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-22   윤신영     최초 생성
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= WaiSpringApplication.class)
class EnneagramTestServiceTest {

    @Autowired
    EnneagramTestService enneagramTestService;

    @Autowired
    UserRepository userRepository;

    String userKey;
    User user;

    @BeforeEach
    void before() {

        userKey = UUID.randomUUID().toString();
        System.out.println("userKey : " + userKey);
        userRepository.deleteByUserKey(userKey);

        user = User.builder().userKey(userKey).build();
        userRepository.save(user);
    }

    @Test
    void saveEnneagramTestResult() {
        EnneagramTestRequestDto enneagramTestRequestDto = EnneagramTestRequestDto.builder()
                .testType(TestType.select)
                .selectedEnneagramType(1)
                .userId(user.getUserId())
                .build();

        enneagramTestService.enneagramTest(enneagramTestRequestDto);
    }
}