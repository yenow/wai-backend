package com.wai.domain.reply;

import com.wai.controller.reply.dto.ReplyRequestDto;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.wai.domain.reply
 * fileName : ReplyCustomRepository
 * author : 윤신영
 * date : 2022-02-03
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-02-03   윤신영     최초 생성
 */
public interface ReplyCustomRepository {

    Optional<Reply> findReplyById(Long replyId);

    Optional<List<Reply>> findAllReplyByPostId(Long postId);
}
