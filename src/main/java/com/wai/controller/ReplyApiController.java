package com.wai.controller;

import com.wai.dto.reply.ReplyRequestDto;
import com.wai.dto.reply.ReplyDto;
import com.wai.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ReplyApiController {

    final ReplyService replyService;

    @GetMapping(value = "/replies/{postId}")
    public List<ReplyDto> getReplies(@PathVariable(value = "postId") Long postId) {
        return replyService.readReplysByPostId(postId);
    }

    @PostMapping(value = "/reply/create")
    public ReplyDto createReply(@RequestBody ReplyRequestDto replyRequestDto) {
        return replyService.createReply(replyRequestDto);
    }

    @DeleteMapping(value = "/reply/{replyId}/delete")
    public ReplyDto deleteReply(@PathVariable(value = "replyId") Long replyId) {
        return replyService.deleteReply(replyId);
    }

    @PostMapping(value = "/reply/report")
    public ReplyDto reportReply(@RequestBody ReplyRequestDto replyRequestDto) {
        return replyService.reportReply(replyRequestDto);
    }
}
