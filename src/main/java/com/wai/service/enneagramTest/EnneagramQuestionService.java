package com.wai.service.enneagramTest;

import com.wai.domain.enneagramQuestion.EnneagramQuestion;
import com.wai.domain.enneagramQuestion.EnneagramQuestionRepository;
import com.wai.domain.enneagramTest.TestType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.wai.service.enneagramTest
 * fileName : EnneagramQuestionService
 * author : 윤신영
 * date : 2022-01-31
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-31   윤신영     최초 생성
 */
@Service
@RequiredArgsConstructor
public class EnneagramQuestionService {

    final EnneagramQuestionRepository enneagramQuestionRepository;


    public List<EnneagramQuestion> getHardEnneagramQuestion() {
        List<EnneagramQuestion> list =  enneagramQuestionRepository.findByTestType(TestType.hard);
        list.stream().forEach(enneagramQuestion -> enneagramQuestion.setQuestionNumberForHardTest(list.indexOf(enneagramQuestion) + 1));
        return list;
    }

    public List<EnneagramQuestion> getSimpleEnneagramQuestion() {
        return enneagramQuestionRepository.findByTestType(TestType.simple);
    }
}
