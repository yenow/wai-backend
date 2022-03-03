package com.wai.controller.enneagram;

import com.wai.controller.enneagram.dto.EnneagramExplainResponseDto;
import com.wai.controller.enneagram.dto.EnneagramDto;
import com.wai.domain.enneagram.EnneagramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enneagram")
public class EnneagramApiController {

    final EnneagramRepository enneagramRepository;

    @GetMapping(value = "/getEnneagramInformation")
    public List<EnneagramDto> getEnneagramInfomation() {
        List<EnneagramDto> list = new ArrayList<>();
        enneagramRepository.findAll().forEach(enneagram ->
                list.add(enneagram.toDto())
        );

        return list;
    }
}
