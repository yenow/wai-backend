package com.wai.controller.enneagram.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.List;

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
