package com.wai.domain.postHistory;

import java.util.Optional;

public interface PostHistoryCustomRepository {

    Optional<PostHistory> findOneByPostIdAndUserId(Long postId, Long userId);
}
