package com.wai.domain.enneagram;

import com.wai.dto.enneagram.EnneagramDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Column
    private String simpleExplain3;

    public EnneagramDto toDto() {
        return EnneagramDto.builder()
                .enneagramType(enneagramType)
                .animalName(animalName)
                .imagePath(imagePath)
                .simpleExplain(simpleExplain)
                .simpleExplain2(simpleExplain2)
                .simpleExplain3(simpleExplain3)
                .subName(subName)
                .build();
    }
}
