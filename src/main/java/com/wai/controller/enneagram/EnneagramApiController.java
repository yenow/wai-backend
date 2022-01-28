package com.wai.controller.enneagram;

import com.wai.controller.dto.ResponseDto;
import com.wai.controller.enneagram.dto.EnneagramExplainResponseDto;
import com.wai.controller.enneagram.dto.EnneagramResponseDto;
import com.wai.controller.enneagramTest.dto.EnneagramTestRequestDto;
import com.wai.domain.enneagram.EnneagramRepository;
import com.wai.domain.enneagramExplain.EnneagramExplainRepository;
import com.wai.service.enneagramTest.EnneagramTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class EnneagramApiController {

    final EnneagramRepository enneagramRepository;
    final EnneagramExplainRepository enneagramExplainRepository;

    @GetMapping(value = "/api/getEnneagramInfomation")
    public List<EnneagramResponseDto> getEnneagramInfomation() {
        List<EnneagramResponseDto> list = new ArrayList<>();
        enneagramRepository.findAll().forEach(enneagram ->
                list.add(enneagram.toDto())
        );

        return list;
    }

    @GetMapping(value = "/api/getEnneagramExplainInfomation")
    public List<EnneagramExplainResponseDto> getEnneagramExplainInfomation() {
        List<EnneagramExplainResponseDto> list = new ArrayList<>();
        enneagramExplainRepository.findAll().forEach(enneagramExplain ->
                list.add(enneagramExplain.toDto())
        );

        return list;
    }
}
