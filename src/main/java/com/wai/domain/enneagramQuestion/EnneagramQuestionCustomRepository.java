package com.wai.domain.enneagramQuestion;

import com.wai.domain.enneagramTest.TestType;

import java.util.List;

/**
 * packageName : com.wai.domain.enneagramQuestion
 * fileName : EnneagramQuestionCustomRepository
 * author : 윤신영
 * date : 2022-01-31
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-31   윤신영     최초 생성
 */
public interface EnneagramQuestionCustomRepository {

    List<EnneagramQuestion> findByTestType (TestType testType);
}
