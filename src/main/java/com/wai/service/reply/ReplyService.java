package com.wai.service.reply;

import com.wai.controller.reply.dto.ReplyRequestDto;
import com.wai.domain.reply.Reply;
import com.wai.domain.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName : com.wai.service.reply
 * fileName : ReplyService
 * author : 윤신영
 * date : 2022-01-24
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-24   윤신영     최초 생성
 */
@RequiredArgsConstructor
@Service
public class ReplyService {

    final ReplyRepository replyRepository;

    public Reply saveReply(ReplyRequestDto replyRequestDto) {
        return replyRepository.save(replyRequestDto.toEntity());
    }
}
