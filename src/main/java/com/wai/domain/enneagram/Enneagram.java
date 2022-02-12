package com.wai.domain.enneagram;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wai.controller.enneagram.dto.EnneagramResponseDto;
import com.wai.domain.wiseSaying.WiseSaying;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.wai.domain.enneagram
 * fileName : Enneagram
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
public class Enneagram {

    @Id
    private Integer enneagramType;

    @Builder.Default
    @OneToMany(mappedBy = "enneagram")
    @JsonManagedReference
    private List<WiseSaying> wiseSayings = new ArrayList<>();

    @Column
    private String animalName;
    @Column
    private String imagePath;
    @Column
    private String subName;
    @Column
    private String simpleExplain;
    @Column
    private String simpleExplain2;
    @Column
    private String simpleExplain3;

    public EnneagramResponseDto toDto() {
        return EnneagramResponseDto.builder()
                .enneagramType(enneagramType)
                .wiseSayings(wiseSayings)
                .animalName(animalName)
                .imagePath(imagePath)
                .simpleExplain(simpleExplain)
                .simpleExplain2(simpleExplain2)
                .simpleExplain3(simpleExplain3)
                .subName(subName)
                .build();
    }
}
