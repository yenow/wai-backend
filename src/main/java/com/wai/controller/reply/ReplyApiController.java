package com.wai.controller.reply;

import com.wai.controller.reply.dto.ReplyRequestDto;
import com.wai.controller.reply.dto.ReplyResponseDto;
import com.wai.controller.user.dto.UserResponseDto;
import com.wai.domain.reply.Reply;
import com.wai.service.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.wai.controller
 * fileName : ReplyApiController
 * author : 윤신영
 * date : 2022-01-24
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-24   윤신영     최초 생성
 */
@RequiredArgsConstructor
@RestController
public class ReplyApiController {

    final ReplyService replyService;

    @PostMapping(value = "/api/saveReply")
    public ReplyResponseDto saveReply(@RequestBody ReplyRequestDto replyRequestDto) {
        return replyService.saveReply(replyRequestDto);
    }

    @GetMapping(value = "/api/readReplysByPostId/{postId}")
    public List<ReplyResponseDto> readReplys(@PathVariable(value = "postId") Long postId) {
        return replyService.readReplysByPostId(postId);
    }
}
