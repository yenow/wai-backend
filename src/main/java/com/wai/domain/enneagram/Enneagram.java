package com.wai.domain.enneagram;

import com.wai.controller.enneagram.dto.EnneagramResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

    public EnneagramResponseDto toDto() {
        return EnneagramResponseDto.builder()
                .enneagramType(enneagramType)
                .animalName(animalName)
                .imagePath(imagePath)
                .simpleExplain(simpleExplain)
                .simpleExplain2(simpleExplain2)
                .subName(subName)
                .build();
    }
}
