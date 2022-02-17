package com.wai.controller.enneagramTest;

import com.wai.controller.dto.ResponseDto;
import com.wai.controller.enneagramTest.dto.EnneagramTestRequestDto;
import com.wai.controller.enneagramTest.dto.EnneagramTestResponseDto;
import com.wai.domain.enneagramQuestion.EnneagramQuestion;
import com.wai.service.enneagramTest.EnneagramQuestionService;
import com.wai.service.enneagramTest.EnneagramTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EnneagramTestApiController {

    private final EnneagramTestService enneagramTestService;

    private final EnneagramQuestionService enneagramQuestionService;

    @PostMapping(value = "/api/saveSelectedEnneagramTestResult")
    public EnneagramTestResponseDto saveSelectedEnneagramTestResult(@RequestBody EnneagramTestRequestDto enneagramTestRequestDto) {
        return enneagramTestService.saveSelectedEnneagramTestResult(enneagramTestRequestDto).toDto();
    }

    @PostMapping(value = "/api/saveSimpleEnneagramTestResult")
    public EnneagramTestResponseDto saveSimpleEnneagramTestResult(@RequestBody EnneagramTestRequestDto enneagramTestRequestDto) {
        return enneagramTestService.saveSimpleEnneagramTestResult(enneagramTestRequestDto).toDto();
    }

    @PostMapping(value = "/api/saveHardEnneagramTestResult")
    public EnneagramTestResponseDto saveHardEnneagramTestResult(@RequestBody EnneagramTestRequestDto enneagramTestRequestDto) {
        return enneagramTestService.saveHardEnneagramTestResult(enneagramTestRequestDto).toDto();
    }

    @GetMapping(value = "/api/getHardEnneagramQuestion")
    public List<EnneagramQuestion> getHardEnneagramQuestion() {
        return enneagramQuestionService.getHardEnneagramQuestion();
    }

    @GetMapping(value = "/api/getSimpleEnneagramQuestion")
    public List<EnneagramQuestion> getSimpleEnneagramQuestion() {
        return enneagramQuestionService.getSimpleEnneagramQuestion();
    }
}
