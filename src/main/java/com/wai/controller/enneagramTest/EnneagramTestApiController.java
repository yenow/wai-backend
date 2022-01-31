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

/**
 * packageName : com.wai.controller
 * fileName : EnneagramTestApiController
 * author : 윤신영
 * date : 2022-01-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-22   윤신영     최초 생성
 */
@RequiredArgsConstructor
@RestController
public class EnneagramTestApiController {

    private final EnneagramTestService enneagramTestService;

    private final EnneagramQuestionService enneagramQuestionService;

    @PostMapping(value = "/api/saveSelectEnneagramTestResult")
    public EnneagramTestResponseDto saveSelectEnneagramTestResult(@RequestBody EnneagramTestRequestDto enneagramTestRequestDto) {
        return enneagramTestService.saveSelectEnneagramTestResult(enneagramTestRequestDto).toDto();
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
