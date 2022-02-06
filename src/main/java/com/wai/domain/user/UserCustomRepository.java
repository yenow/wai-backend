package com.wai.domain.user;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * packageName : com.wai.domain.user
 * fileName : CustomUserRepository
 * author : 윤신영
 * date : 2021-12-21
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-21   윤신영     최초 생성
 */
public interface UserCustomRepository {

    User findByEmail(String id);

    User findByPhoneNumber(String id);

    User findByUserKey(String userKey);

    Optional<User> findByNickname(String nickname);

    @Transactional
    void deleteByUserKey(String userKey);
}
