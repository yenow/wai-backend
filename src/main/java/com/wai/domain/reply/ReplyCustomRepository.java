package com.wai.domain.reply;

import java.util.List;
import java.util.Optional;

public interface ReplyCustomRepository {

    Optional<Reply> findReplyById(Long replyId);

    Optional<List<Reply>> findAllReplyByPostId(Long postId);
}
