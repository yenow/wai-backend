package com.wai.controller.enneagram.dto;

import com.wai.domain.enneagramTest.TestType;
import com.wai.domain.wiseSaying.WiseSaying;
import lombok.*;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EnneagramDto {
    private boolean isSuccess;
    @Builder.Default
    private List<WiseSaying> wiseSayings =  new ArrayList<>();
    private Integer enneagramType;
    private String animalName;
    private String imagePath;
    private String subName;
    private String simpleExplain;
    private String simpleExplain2;
    private String simpleExplain3;
}
