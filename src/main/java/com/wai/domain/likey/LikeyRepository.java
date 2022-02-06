package com.wai.domain.likey;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.wai.domain.likey
 * fileName : LikeyRepository
 * author : 윤신영
 * date : 2022-02-04
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-02-04   윤신영     최초 생성
 */
public interface LikeyRepository extends JpaRepository<Likey, Long>, LikeyCustomRepository {
}
