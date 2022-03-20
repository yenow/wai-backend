package com.wai.dto.enneagramTest;

import com.wai.domain.common.BaseEntity;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.enneagramTest.TestType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EnneagramTestDto extends BaseEntity {
    private Long testId;
    private Long userId;
    private TestType testType;
    private Integer myEnneagramType;
    private Integer myWingType;
    private String uniqueString;
    private Integer type1Score;
    private Integer type2Score;
    private Integer type3Score;
    private Integer type4Score;
    private Integer type5Score;
    private Integer type6Score;
    private Integer type7Score;
    private Integer type8Score;
    private Integer type9Score;
    private LocalDateTime insertDate;

    public EnneagramTestDto(EnneagramTest enneagramTest) {
        this.testId = enneagramTest.getTestId();
        this.testType = enneagramTest.getTestType();
        this.myEnneagramType = enneagramTest.getMyEnneagramType();
        this.myWingType = enneagramTest.getMyWingType();
        this.type1Score = enneagramTest.getType1Score();
        this.type2Score = enneagramTest.getType2Score();
        this.type3Score = enneagramTest.getType3Score();
        this.type4Score = enneagramTest.getType4Score();
        this.type5Score = enneagramTest.getType5Score();
        this.type6Score = enneagramTest.getType6Score();
        this.type7Score = enneagramTest.getType7Score();
        this.type8Score = enneagramTest.getType8Score();
        this.type9Score = enneagramTest.getType9Score();
        this.insertDate = enneagramTest.getInsertDate();
    }
}
