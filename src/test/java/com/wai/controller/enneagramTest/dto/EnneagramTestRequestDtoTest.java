package com.wai.controller.enneagramTest.dto;

import com.wai.dto.enneagramTest.EnneagramTestRequestDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class EnneagramTestRequestDtoTest {

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
