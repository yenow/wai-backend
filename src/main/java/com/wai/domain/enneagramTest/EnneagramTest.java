package com.wai.domain.enneagramTest;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wai.common.BaseEntity;
import com.wai.controller.enneagramTest.dto.EnneagramTestResponseDto;
import com.wai.domain.userEnneagramTest.UserEnneagramTest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.wai.domain.enneagramTest
 * fileName : EnneagramTest
 * author : 윤신영
 * date : 2021-12-23
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-23   윤신영     최초 생성
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EnneagramTest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testId;

    @OneToMany(mappedBy = "enneagramTest")
    @JsonManagedReference
    private List<UserEnneagramTest> userEnneagramTests = new ArrayList<UserEnneagramTest>();;

    @Column
    @Enumerated(value = EnumType.STRING)
    private TestType testType;
    @Column
    private int myEnneagramType;
    @Column
    private int myWingType;
    @Column
    private int type1Score;
    @Column
    private int type2Score;
    @Column
    private int type3Score;
    @Column
    private int type4Score;
    @Column
    private int type5Score;
    @Column
    private int type6Score;
    @Column
    private int type7Score;
    @Column
    private int type8Score;
    @Column
    private int type9Score;

    public EnneagramTestResponseDto toDto() {
        return EnneagramTestResponseDto.builder()
                .isSuccess(true)
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
                .build();
    }
}
