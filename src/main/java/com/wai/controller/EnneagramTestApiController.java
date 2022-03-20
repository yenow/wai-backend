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

    @PostMapping(value = "/doSelectedEnneagramTestResult")
    public EnneagramTestDto doSelectedEnneagramTestResult(@RequestBody EnneagramTestRequestDto enneagramTestRequestDto) {
        return enneagramTestService.doSelectedEnneagramTestResult(enneagramTestRequestDto).toDto();
    }

    @PostMapping(value = "/doSimpleEnneagramTest")
    public EnneagramTestDto doSimpleEnneagramTestResult(@RequestBody EnneagramTestRequestDto enneagramTestRequestDto) {
        return enneagramTestService.doSimpleEnneagramTestResult(enneagramTestRequestDto).toDto();
    }

    @PostMapping(value = "/doHardEnneagramTest")
    public EnneagramTestDto doHardEnneagramTestResult(@RequestBody EnneagramTestRequestDto enneagramTestRequestDto) {
        return enneagramTestService.doHardEnneagramTestResult(enneagramTestRequestDto).toDto();
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
