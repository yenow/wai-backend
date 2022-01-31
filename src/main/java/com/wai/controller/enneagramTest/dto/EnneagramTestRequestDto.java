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
    private int myWingType;
    private String uniqueString;
    private int type1Score;
    private int type2Score;
    private int type3Score;
    private int type4Score;
    private int type5Score;
    private int type6Score;
    private int type7Score;
    private int type8Score;
    private int type9Score;

    public void CalculateSimpleEnneagramTest() {
        switch (uniqueString) {
            case "AX" :
                myEnneagramType = 7;
                break;
            case "AY" :
                myEnneagramType = 8;
                break;
            case "AZ" :
                myEnneagramType = 3;
                break;
            case "BX" :
                myEnneagramType = 9;
                break;
            case "BY" :
                myEnneagramType = 4;
                break;
            case "BZ" :
                myEnneagramType = 5;
                break;
            case "CX" :
                myEnneagramType = 2;
                break;
            case "CY" :
                myEnneagramType = 6;
                break;
            case "CZ" :
                myEnneagramType = 1;
                break;
        }
    }

    public EnneagramTest toEntity() {
        return EnneagramTest.builder()
                .testId(testId)
                .testType(testType)
                .myEnneagramType(myEnneagramType)
                .myWingType(myWingType)
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
