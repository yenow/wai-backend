package com.wai.domain.personalityTest;

import com.wai.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * packageName : com.wai.domain.personalityTest
 * fileName : PersonalityTest
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
public class PersonalityTest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testId;

    @Enumerated(value = EnumType.STRING)
    private TestType testType;

    @Column(nullable = false)
    private LocalDateTime testDate;

    @Builder
    public PersonalityTest(Long testId, TestType testType, LocalDateTime testDate) {
        this.testId = testId;
        this.testType = testType;
        this.testDate = testDate;
    }
}
