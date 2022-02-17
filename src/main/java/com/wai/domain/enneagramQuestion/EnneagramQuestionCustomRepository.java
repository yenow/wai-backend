package com.wai.domain.enneagramQuestion;

import com.wai.domain.enneagramTest.TestType;

import java.util.List;

public interface EnneagramQuestionCustomRepository {

    List<EnneagramQuestion> findByTestType (TestType testType);
}
