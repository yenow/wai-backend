package com.wai.domain.enneagramExplain;

import com.wai.controller.enneagram.dto.EnneagramExplainResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;

/**
 * packageName : com.wai.domain.enneagramExplain
 * fileName : enneagramExplain
 * author : 윤신영
 * date : 2022-01-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-22   윤신영     최초 생성
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EnneagramExplain {

    @Id
    private Integer enneagramType;

    @Column
    private String basicExplains;
    @Column
    private String merits;
    @Column
    private String demerits;
    @Column
    private String humanRelations;
    @Column
    private String surroundingEvaluations;
    @Column
    private String friendWays;
    @Column
    private String hardWorks;
    @Column
    private String comfortSentences;

    public EnneagramExplainResponseDto toDto() {
        return EnneagramExplainResponseDto.builder()
                .enneagramType(enneagramType)
                .basicExplains(Arrays.asList(basicExplains.split("\\|")))
                .merits(Arrays.asList(merits.split("\\|")))
                .demerits(Arrays.asList(demerits.split("\\|")))
                .humanRelations(Arrays.asList(humanRelations.split("\\|")))
                .surroundingEvaluations(Arrays.asList(surroundingEvaluations.split("\\|")))
                .friendWays(Arrays.asList(friendWays.split("\\|")))
                .hardWorks(Arrays.asList(hardWorks.split("\\|")))
                .comfortSentences(Arrays.asList(comfortSentences.split("\\|")))
                .build();
    }
}