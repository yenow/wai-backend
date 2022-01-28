package com.wai.domain.enneagram;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.wai.domain.enneagram
 * fileName : EnneagramRepository
 * author : 윤신영
 * date : 2022-01-28
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-28   윤신영     최초 생성
 */
public interface EnneagramRepository extends JpaRepository<Enneagram, Integer> {
}
