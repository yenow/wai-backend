package com.wai.controller.enneagramTest;

import com.wai.controller.dto.ResponseDto;
import com.wai.controller.enneagramTest.dto.EnneagramTestRequestDto;
import com.wai.service.enneagramTest.EnneagramTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value = "/api/enneagramTest")
    public ResponseDto enneagramTest(@RequestBody EnneagramTestRequestDto enneagramTestRequestDto) {
        enneagramTestService.enneagramTest(enneagramTestRequestDto);
        //return EnneagramTestResponseDto.builder().isSuccess(true).build();
        return ResponseDto.builder().isSuccess(true).errorMessage("").build();
    }
}
