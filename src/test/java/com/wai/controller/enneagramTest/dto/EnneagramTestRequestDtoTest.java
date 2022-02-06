package com.wai.controller.enneagramTest.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : com.wai.controller.enneagramTest.dto
 * fileName : EnneagramTestRequestDtoTest
 * author : 윤신영
 * date : 2022-02-01
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-02-01   윤신영     최초 생성
 */
class EnneagramTestRequestDtoTest {

    @Test
    void calculateHardEnneagramTest() {
        EnneagramTestRequestDto enneagramTestRequestDto = EnneagramTestRequestDto.builder()
                .type1Score(30)
                .type2Score(1)
                .type3Score(1)
                .type4Score(1)
                .type5Score(1)
                .type6Score(1)
                .type7Score(1)
                .type8Score(1)
                .type9Score(1)
                .build();

        enneagramTestRequestDto.calculateHardEnneagramTest();
        assertEquals(1, enneagramTestRequestDto.getMyEnneagramType());

        enneagramTestRequestDto = EnneagramTestRequestDto.builder()
                .type1Score(30)
                .type2Score(2)
                .type3Score(1)
                .type4Score(1)
                .type5Score(1)
                .type6Score(30)
                .type7Score(5)
                .type8Score(1)
                .type9Score(1)
                .build();

        enneagramTestRequestDto.calculateHardEnneagramTest();
        assertEquals(6, enneagramTestRequestDto.getMyEnneagramType());
    }
}
