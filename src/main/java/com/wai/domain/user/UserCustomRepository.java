package com.wai.domain.user;

import javax.transaction.Transactional;
import java.util.Optional;


public interface UserCustomRepository {

    User findByEmail(String id);

    Optional<User> findByUserKey(String userKey);

    Optional<User> findByNickname(String nickname);

    @Transactional
    void deleteByUserKey(String userKey);
}
