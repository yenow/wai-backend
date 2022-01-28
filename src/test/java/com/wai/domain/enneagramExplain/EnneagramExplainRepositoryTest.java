package com.wai.domain.enneagramExplain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : com.wai.domain.enneagramExplain
 * fileName : EnneagramExplainRepositoryTest
 * author : 윤신영
 * date : 2022-01-28
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-28   윤신영     최초 생성
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class EnneagramExplainRepositoryTest {

    @Autowired
    private EnneagramExplainRepository enneagramExplainRepository;

    @BeforeEach
    void beforeEach() {
        enneagramExplainRepository.deleteAll();
    }

    @Test
    void insertData() {
        enneagramExplainRepository.save(EnneagramExplain.builder()
                .enneagramType(1)
                .basicExplains("temp")
                .merits("temp")
                .demerits("temp")
                .comfortSentences("temp")
                .friendWays("temp")
                .hardWorks("temp")
                .humanRelations("temp")
                .surroundingEvaluations("temp")
                .build());

        enneagramExplainRepository.save(EnneagramExplain.builder()
                .enneagramType(2)
                .basicExplains("temp")
                .merits("temp")
                .demerits("temp")
                .comfortSentences("temp")
                .friendWays("temp")
                .hardWorks("temp")
                .humanRelations("temp")
                .surroundingEvaluations("temp")
                .build());

        enneagramExplainRepository.save(EnneagramExplain.builder()
                .enneagramType(3)
                .basicExplains("temp")
                .merits("temp")
                .demerits("temp")
                .comfortSentences("temp")
                .friendWays("temp")
                .hardWorks("temp")
                .humanRelations("temp")
                .surroundingEvaluations("temp")
                .build());

        enneagramExplainRepository.save(EnneagramExplain.builder()
                .enneagramType(4)
                .basicExplains("temp")
                .merits("temp")
                .demerits("temp")
                .comfortSentences("temp")
                .friendWays("temp")
                .hardWorks("temp")
                .humanRelations("temp")
                .surroundingEvaluations("temp")
                .build());

        enneagramExplainRepository.save(EnneagramExplain.builder()
                .enneagramType(5)
                .basicExplains("temp")
                .merits("temp")
                .demerits("temp")
                .comfortSentences("temp")
                .friendWays("temp")
                .hardWorks("temp")
                .humanRelations("temp")
                .surroundingEvaluations("temp")
                .build());

        enneagramExplainRepository.save(EnneagramExplain.builder()
                .enneagramType(6)
                .basicExplains("temp")
                .merits("temp")
                .demerits("temp")
                .comfortSentences("temp")
                .friendWays("temp")
                .hardWorks("temp")
                .humanRelations("temp")
                .surroundingEvaluations("temp")
                .build());

        enneagramExplainRepository.save(EnneagramExplain.builder()
                .enneagramType(7)
                .basicExplains("temp")
                .merits("temp")
                .demerits("temp")
                .comfortSentences("temp")
                .friendWays("temp")
                .hardWorks("temp")
                .humanRelations("temp")
                .surroundingEvaluations("temp")
                .build());

        enneagramExplainRepository.save(EnneagramExplain.builder()
                .enneagramType(8)
                .basicExplains("temp")
                .merits("temp")
                .demerits("temp")
                .comfortSentences("temp")
                .friendWays("temp")
                .hardWorks("temp")
                .humanRelations("temp")
                .surroundingEvaluations("temp")
                .build());

        enneagramExplainRepository.save(EnneagramExplain.builder()
                .enneagramType(9)
                .basicExplains("temp")
                .merits("temp")
                .demerits("temp")
                .comfortSentences("temp")
                .friendWays("temp")
                .hardWorks("temp")
                .humanRelations("temp")
                .surroundingEvaluations("temp")
                .build());
    }

}