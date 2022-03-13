package com.wai.domain.wiseSaying;

import com.wai.dto.wiseSaying.WiseSayingRequestDto;

import java.util.Optional;

public interface WiseSayingCustomRepository {
    Optional<WiseSaying> getWiseSayings(WiseSayingRequestDto wiseSayingRequestDto);
}
