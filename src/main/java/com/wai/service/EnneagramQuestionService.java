package com.wai.service;

import com.wai.domain.enneagramQuestion.EnneagramQuestion;
import com.wai.domain.enneagramQuestion.EnneagramQuestionRepository;
import com.wai.domain.enneagramTest.TestType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EnneagramQuestionService {

    final EnneagramQuestionRepository enneagramQuestionRepository;

    public List<EnneagramQuestion> getHardEnneagramQuestion() {
        List<EnneagramQuestion> list =  enneagramQuestionRepository.findByTestType(TestType.hard);
        list.forEach(enneagramQuestion -> enneagramQuestion.setQuestionNumberForHardTest(list.indexOf(enneagramQuestion) + 1));
        return list;
    }

    public List<EnneagramQuestion> getSimpleEnneagramQuestion() {
        return enneagramQuestionRepository.findByTestType(TestType.simple);
    }
}
