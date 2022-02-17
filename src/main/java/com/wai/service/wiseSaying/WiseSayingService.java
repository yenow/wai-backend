package com.wai.service.wiseSaying;

import com.wai.controller.wiseSaying.dto.WiseSayingRequestDto;
import com.wai.controller.wiseSaying.dto.WiseSayingResponseDto;
import com.wai.domain.wiseSaying.WiseSaying;
import com.wai.domain.wiseSaying.WiseSayingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WiseSayingService {

    final WiseSayingRepository wiseSayingRepository;

    public WiseSayingResponseDto getWiseSaying(WiseSayingRequestDto wiseSayingRequestDto) {
        WiseSaying wiseSaying = wiseSayingRepository.getWiseSayings(wiseSayingRequestDto).orElse(WiseSaying.builder().build());
        return wiseSaying.toDto();
    }
}
