package com.wai.controller.enneagram;

import com.wai.controller.enneagram.dto.EnneagramExplainResponseDto;
import com.wai.controller.enneagram.dto.EnneagramDto;
import com.wai.domain.enneagram.EnneagramRepository;
import com.wai.domain.enneagramExplain.EnneagramExplainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class EnneagramApiController {

    final EnneagramRepository enneagramRepository;
    final EnneagramExplainRepository enneagramExplainRepository;

    @GetMapping(value = "/api/getEnneagramInfomation")
    public List<EnneagramDto> getEnneagramInfomation() {
        List<EnneagramDto> list = new ArrayList<>();
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
