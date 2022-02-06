package com.wai.domain.likey;

import java.util.Optional;

/**
 * packageName : com.wai.domain.likey
 * fileName : LikeyCustomRepository
 * author : 윤신영
 * date : 2022-02-04
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-02-04   윤신영     최초 생성
 */
public interface LikeyCustomRepository {

    Optional<Likey> findByUserIdAndPostId(Long userId, Long postId);
}
