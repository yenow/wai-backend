package com.wai.domain.enneagramTest;

import com.wai.common.BaseEntity;
import com.wai.domain.userEnneagramTest.UserEnneagramTest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
@Entity
public class EnneagramTest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testId;

    @OneToMany(mappedBy = "enneagramTest")
    private List<UserEnneagramTest> userEnneagramTests = new ArrayList<UserEnneagramTest>();;

    @Column
    @Enumerated(value = EnumType.STRING)
    private TestType testType;
    @Column
    private int selectedEnneagramType;
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

    @Builder
    public EnneagramTest(Long testId, List<UserEnneagramTest> userEnneagramTests, TestType testType, int selectedEnneagramType, int type1Score, int type2Score, int type3Score, int type4Score, int type5Score, int type6Score, int type7Score, int type8Score, int type9Score) {
        this.testId = testId;
        this.userEnneagramTests = userEnneagramTests;
        this.testType = testType;
        this.selectedEnneagramType = selectedEnneagramType;
        this.type1Score = type1Score;
        this.type2Score = type2Score;
        this.type3Score = type3Score;
        this.type4Score = type4Score;
        this.type5Score = type5Score;
        this.type6Score = type6Score;
        this.type7Score = type7Score;
        this.type8Score = type8Score;
        this.type9Score = type9Score;
    }
}
