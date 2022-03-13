package com.wai.service;

import com.wai.dto.wiseSaying.WiseSayingRequestDto;
import com.wai.dto.wiseSaying.WiseSayingResponseDto;
import com.wai.domain.wiseSaying.WiseSaying;
import com.wai.domain.wiseSaying.WiseSayingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WiseSayingService {

    final WiseSayingRepository wiseSayingRepository;

    public WiseSayingResponseDto getWiseSaying(WiseSayingRequestDto wiseSayingRequestDto) {
        WiseSaying wiseSaying = wiseSayingRepository.getWiseSayings(wiseSayingRequestDto).orElse(WiseSaying.builder().build());
        return wiseSaying.toDto();
    }
}
