package com.wai.controller.enneagramTest;

import com.wai.controller.enneagramTest.dto.EnneagramTestRequestDto;
import com.wai.controller.enneagramTest.dto.EnneagramTestDto;
import com.wai.domain.enneagramQuestion.EnneagramQuestion;
import com.wai.service.enneagramTest.EnneagramQuestionService;
import com.wai.service.enneagramTest.EnneagramTestService;
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

    @PostMapping(value = "/saveSimpleEnneagramTestResult")
    public EnneagramTestDto saveSimpleEnneagramTestResult(@RequestBody EnneagramTestRequestDto enneagramTestRequestDto) {
        return enneagramTestService.saveSimpleEnneagramTestResult(enneagramTestRequestDto).toDto();
    }

    @PostMapping(value = "/saveHardEnneagramTestResult")
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
