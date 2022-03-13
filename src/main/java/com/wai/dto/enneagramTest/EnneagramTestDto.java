package com.wai.dto.enneagramTest;

import com.wai.domain.enneagramTest.TestType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EnneagramTestDto {
    private boolean isSuccess;
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
}
