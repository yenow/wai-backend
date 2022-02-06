package com.wai.controller.enneagramTest.dto;

import com.wai.controller.dto.ResponseDto;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.enneagramTest.TestType;
import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName : com.wai.controller.dto.enneagramTest
 * fileName : EnneagramTestResponseDto
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
@AllArgsConstructor
public class EnneagramTestResponseDto {
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
