package com.wai.domain.follow;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.wai.domain.follow
 * fileName : FollowRepository
 * author : 윤신영
 * date : 2021-12-21
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-21   윤신영     최초 생성
 */
public interface FollowRepository extends JpaRepository<Follow,Long> {
}
