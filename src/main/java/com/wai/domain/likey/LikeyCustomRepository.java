package com.wai.domain.likey;

import java.util.Optional;

public interface LikeyCustomRepository {

    Optional<Likey> findByUserIdAndPostId(Long userId, Long postId);
}
