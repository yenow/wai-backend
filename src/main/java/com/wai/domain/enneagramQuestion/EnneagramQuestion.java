package com.wai.domain.enneagramQuestion;

import com.wai.domain.enneagramTest.TestType;
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
public class EnneagramQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private TestType testType;
    @Column
    private int questionNumber;
    @Column(length = 4000)
    private String question;
    @Column
    private int enneagramType;
    @Column(length = 1)
    private String uniqueString;

    public void setQuestionNumberForHardTest(int questionNumber) {
        this.questionNumber = questionNumber;
    }

}
