package com.wai.controller.dto.enneagramTest;

import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.enneagramTest.TestType;
import lombok.*;

/**
 * packageName : com.wai.controller.dto.enneagramTest
 * fileName : EnneagramTestRequestDto
 * author : 윤신영
 * date : 2022-01-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-22   윤신영     최초 생성
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class EnneagramTestRequestDto {

    private Long testId;
    private Long userId;
    private TestType testType;
    private int selectedEnneagramType;
    private int type1Score;
    private int type2Score;
    private int type3Score;
    private int type4Score;
    private int type5Score;
    private int type6Score;
    private int type7Score;
    private int type8Score;
    private int type9Score;

    public EnneagramTest toEntity() {
        return EnneagramTest.builder()
                .testId(testId)
                .testType(testType)
                .selectedEnneagramType(selectedEnneagramType)
                .type1Score(type1Score)
                .type2Score(type2Score)
                .type3Score(type3Score)
                .type4Score(type4Score)
                .type5Score(type5Score)
                .type6Score(type6Score)
                .type7Score(type7Score)
                .type7Score(type8Score)
                .type9Score(type9Score)
                .build();
    }


    @Builder
    public EnneagramTestRequestDto(Long testId, Long userId, TestType testType, int selectedEnneagramType, int type1Score, int type2Score, int type3Score, int type4Score, int type5Score, int type6Score, int type7Score, int type8Score, int type9Score) {
        this.testId = testId;
        this.userId = userId;
        this.testType = testType;
        this.selectedEnneagramType = selectedEnneagramType;
        this.type1Score = type1Score;
        this.type2Score = type2Score;
        this.type3Score = type3Score;
        this.type4Score = type4Score;
        this.type5Score = type5Score;
        this.type6Score = type6Score;
        this.type7Score = type7Score;
        this.type8Score = type8Score;
        this.type9Score = type9Score;
    }
}
