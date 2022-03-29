package com.wai.controller;

import com.wai.domain.notice.Notice;
import com.wai.dto.ResponseDto;
import com.wai.dto.notice.NoticeDto;
import com.wai.dto.notice.NoticeRequestDto;
import com.wai.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class NoticeApiController {

    final private NoticeService noticeService;

    @PostMapping("/notices")
    public List<NoticeDto> getNotices(@RequestBody NoticeRequestDto noticeRequestDto) {
        return noticeService.getNoticeDtos(noticeRequestDto);
    }

    @PostMapping("/notice/clear")
    public NoticeDto clearNotice(@RequestBody NoticeRequestDto noticeRequestDto) {
        return noticeService.clearNotice(noticeRequestDto);
    }

    @PostMapping("/notice/clearAll")
    public ResponseDto clearAllNotice(@RequestBody NoticeRequestDto noticeRequestDto) {
        noticeService.clearAllNotice(noticeRequestDto);
        return ResponseDto.builder().nowServerTime(LocalDateTime.now()).build();
    }
}
