package com.wai.controller.wiseSaying;

import com.wai.controller.wiseSaying.dto.WiseSayingRequestDto;
import com.wai.controller.wiseSaying.dto.WiseSayingResponseDto;
import com.wai.service.wiseSaying.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
