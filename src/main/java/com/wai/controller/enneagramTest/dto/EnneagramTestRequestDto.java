package com.wai.controller.enneagramTest.dto;

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
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EnneagramTestRequestDto {

    private Long testId;
    private Long userId;
    private TestType testType;
    private int myEnneagramType;
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
                .myEnneagramType(myEnneagramType)
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
}
