package com.wai.domain.wiseSaying;

import com.wai.controller.wiseSaying.dto.WiseSayingRequestDto;

import java.util.List;
import java.util.Optional;

public interface WiseSayingCustomRepository {
    Optional<WiseSaying> getWiseSayings(WiseSayingRequestDto wiseSayingRequestDto);
}
