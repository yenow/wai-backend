package com.wai.service;

import com.wai.domain.notice.Notice;
import com.wai.domain.notice.NoticeRepository;
import com.wai.dto.notice.NoticeDto;
import com.wai.dto.notice.NoticeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoticeService {

    final private NoticeRepository noticeRepository;

    public List<NoticeDto> getNoticeDtos(NoticeRequestDto noticeRequestDto) {
        return noticeRepository.getNoticesDto(noticeRequestDto);
    }

    @Transactional
    public NoticeDto clearNotice(NoticeRequestDto noticeRequestDto) {
        Notice notice = noticeRepository.findById(noticeRequestDto.getNoticeId()).orElseThrow();
        notice.clear();
        return new NoticeDto(notice);
    }

    @Transactional
    public void clearAllNotice(NoticeRequestDto noticeRequestDto) {
        System.out.println("noticeRequestDto = " + noticeRequestDto);
        noticeRepository.clearAll(noticeRequestDto);
    }
}
