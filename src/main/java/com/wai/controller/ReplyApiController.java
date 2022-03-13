package com.wai.controller;

import com.wai.dto.reply.ReplyRequestDto;
import com.wai.dto.reply.ReplyDto;
import com.wai.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class ReplyApiController {

    final ReplyService replyService;

    @GetMapping(value = "/api/readReplysByPostId/{postId}")
    public List<ReplyDto> readReplys(@PathVariable(value = "postId") Long postId) {
        return replyService.readReplysByPostId(postId);
    }

    @PostMapping(value = "/api/saveReply")
    public ReplyDto saveReply(@RequestBody ReplyRequestDto replyRequestDto) {
        return replyService.saveReply(replyRequestDto);
    }

    @PostMapping(value = "/api/deleteReply")
    public ReplyDto deleteReply(@RequestBody ReplyRequestDto replyRequestDto) {
        return replyService.deleteReply(replyRequestDto);
    }

    @PostMapping(value = "/api/reportReply")
    public ReplyDto reportReply(@RequestBody ReplyRequestDto replyRequestDto) {
        return replyService.reportReply(replyRequestDto);
    }
}
