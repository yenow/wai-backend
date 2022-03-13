package com.wai.controller;

import com.wai.dto.wiseSaying.WiseSayingRequestDto;
import com.wai.dto.wiseSaying.WiseSayingResponseDto;
import com.wai.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class WiseSayingApiController {

    final WiseSayingService wiseSayingService;

    @PostMapping(value = "/api/getWiseSaying")
    public WiseSayingResponseDto getWiseSaying(@RequestBody WiseSayingRequestDto wiseSayingRequestDto) {
        return wiseSayingService.getWiseSaying(wiseSayingRequestDto);
    }
}
