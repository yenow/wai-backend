package com.wai.controller;

import com.wai.dto.enneagramTest.EnneagramTestRequestDto;
import com.wai.dto.enneagramTest.EnneagramTestDto;
import com.wai.domain.enneagramQuestion.EnneagramQuestion;
import com.wai.service.EnneagramQuestionService;
import com.wai.service.EnneagramTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/enneagramTest")
public class EnneagramTestApiController {

    private final EnneagramTestService enneagramTestService;

    private final EnneagramQuestionService enneagramQuestionService;

    @PostMapping(value = "/saveSelectedEnneagramTestResult")
    public EnneagramTestDto saveSelectedEnneagramTestResult(@RequestBody EnneagramTestRequestDto enneagramTestRequestDto) {
        return enneagramTestService.saveSelectedEnneagramTestResult(enneagramTestRequestDto).toDto();
    }

    @PostMapping(value = "/saveSimpleEnneagramTest")
    public EnneagramTestDto saveSimpleEnneagramTestResult(@RequestBody EnneagramTestRequestDto enneagramTestRequestDto) {
        return enneagramTestService.saveSimpleEnneagramTestResult(enneagramTestRequestDto).toDto();
    }

    @PostMapping(value = "/saveHardEnneagramTest")
    public EnneagramTestDto saveHardEnneagramTestResult(@RequestBody EnneagramTestRequestDto enneagramTestRequestDto) {
        return enneagramTestService.saveHardEnneagramTestResult(enneagramTestRequestDto).toDto();
    }

    @GetMapping(value = "/getHardEnneagramQuestion")
    public List<EnneagramQuestion> getHardEnneagramQuestion() {
        return enneagramQuestionService.getHardEnneagramQuestion();
    }

    @GetMapping(value = "/getSimpleEnneagramQuestion")
    public List<EnneagramQuestion> getSimpleEnneagramQuestion() {
        return enneagramQuestionService.getSimpleEnneagramQuestion();
    }
}
