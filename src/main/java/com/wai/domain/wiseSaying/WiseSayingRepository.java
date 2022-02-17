package com.wai.domain.wiseSaying;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface WiseSayingRepository extends JpaRepository<WiseSaying, Long>, WiseSayingCustomRepository {
}
