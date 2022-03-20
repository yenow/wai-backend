package com.wai.domain.enneagramTest;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wai.domain.common.BaseEntity;
import com.wai.dto.enneagramTest.EnneagramTestDto;
import com.wai.domain.userEnneagramTest.UserEnneagramTest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Builder @NoArgsConstructor @AllArgsConstructor @ToString(exclude = "userEnneagramTests")
@Entity
public class EnneagramTest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testId;

    @Builder.Default
    @OneToMany(mappedBy = "enneagramTest")
    @JsonManagedReference
    private List<UserEnneagramTest> userEnneagramTests = new ArrayList<UserEnneagramTest>();;

    @Column
    @Enumerated(value = EnumType.STRING)
    private TestType testType;
    @Column
    private Integer myEnneagramType;
    @Column
    private Integer myWingType;
    @Column
    private Integer type1Score;
    @Column
    private Integer type2Score;
    @Column
    private Integer type3Score;
    @Column
    private Integer type4Score;
    @Column
    private Integer type5Score;
    @Column
    private Integer type6Score;
    @Column
    private Integer type7Score;
    @Column
    private Integer type8Score;
    @Column
    private Integer type9Score;

    public EnneagramTestDto toDto() {
        return EnneagramTestDto.builder()
                .testId(testId)
                .testType(testType)
                .myEnneagramType(myEnneagramType)
                .myWingType(myWingType)
                .type1Score(type1Score)
                .type2Score(type2Score)
                .type3Score(type3Score)
                .type4Score(type4Score)
                .type5Score(type5Score)
                .type6Score(type6Score)
                .type7Score(type7Score)
                .type8Score(type8Score)
                .type9Score(type9Score)
                .insertDate(getInsertDate())
                .build();
    }
}
