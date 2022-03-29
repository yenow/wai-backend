package com.wai.domain.notice;

import com.wai.dto.notice.NoticeDto;
import com.wai.dto.notice.NoticeRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long>, NoticeCustomRepository{
}
