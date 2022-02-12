package com.wai.domain.wiseSaying;

import com.wai.WaiSpringApplication;
import com.wai.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : com.wai.domain.wiseSaying
 * fileName : WiseSayingRepositoryTest
 * author : 윤신영
 * date : 2022-01-26
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-26   윤신영     최초 생성
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= WaiSpringApplication.class)
public class WiseSayingRepositoryTest {

    @Autowired
    private WiseSayingRepository wiseSayingRepository;

    @DisplayName("명언 등록")
    @Test
    void insertWiseSaying() {
        WiseSaying wiseSaying = WiseSaying.builder()
                .wiseSaying("읽다 죽어도 멋져 보일 책을 항상 읽으라.")
                .author("P. J. 오루크")
                .build();

        wiseSayingRepository.save(wiseSaying);
    }

}