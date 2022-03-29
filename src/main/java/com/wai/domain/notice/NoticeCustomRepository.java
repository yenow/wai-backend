package com.wai.domain.notice;

import com.wai.dto.notice.NoticeDto;
import com.wai.dto.notice.NoticeRequestDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NoticeCustomRepository {
    List<NoticeDto> getNoticesDto(NoticeRequestDto noticeRequestDto);

//    @Modifying(clearAutomatically = true)
    void clearAll(NoticeRequestDto noticeRequestDto);
}
