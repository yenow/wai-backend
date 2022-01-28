package com.wai.controller.enneagram.dto;

import com.wai.domain.enneagramTest.TestType;
import lombok.*;

import javax.persistence.Column;

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
public class EnneagramResponseDto {
    private boolean isSuccess;
    private Integer enneagramType;
    private String animalName;
    private String imagePath;
    private String subName;
    private String simpleExplain;
    private String simpleExplain2;
}
