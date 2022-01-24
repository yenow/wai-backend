package com.wai.controller.enneagramTest.dto;

import com.wai.controller.dto.ResponseDto;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.enneagramTest.TestType;
import lombok.*;

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
}
