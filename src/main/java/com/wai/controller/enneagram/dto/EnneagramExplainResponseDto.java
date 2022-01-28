package com.wai.controller.enneagram.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.List;

/**
 * packageName : com.wai.controller.enneagram.dto
 * fileName : EnneagramExplainResponseDto
 * author : 윤신영
 * date : 2022-01-28
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-28   윤신영     최초 생성
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EnneagramExplainResponseDto {
    private boolean isSuccess;
    private Integer enneagramType;
    private List<String> basicExplains;
    private List<String> merits;
    private List<String> demerits;
    private List<String> humanRelations;
    private List<String> surroundingEvaluations;
    private List<String> friendWays;
    private List<String> hardWorks;
    private List<String> comfortSentences;
}
