package com.wai.dto.notice;

import com.querydsl.core.annotations.QueryProjection;
import com.wai.domain.notice.Notice;
import com.wai.domain.notice.NoticeType;
import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class NoticeDto {
    private Long noticeId;
    private String giverNickname;
    private Long targetPostId;
    private Long targetReplyId;

    private NoticeType noticeType;
    private String content;
    private Boolean isRead;

    private LocalDateTime insertDate;

    public NoticeDto(Notice notice) {
        this.noticeId = notice.getNoticeId();
        this.giverNickname = notice.getGiver().getNickname();
        this.targetPostId = notice.getTargetPost().getPostId();
        this.targetReplyId = notice.getTargetReply().getReplyId();
        this.noticeType = notice.getNoticeType();
        this.content = notice.getContent();
        this.isRead = notice.getIsRead();
        this.insertDate = notice.getInsertDate();
    }


    @QueryProjection
    public NoticeDto(Long noticeId, String giverNickname, Long targetPostId, Long targetReplyId, NoticeType noticeType, String content, Boolean isRead, LocalDateTime insertDate) {
        this.noticeId = noticeId;
        this.giverNickname = giverNickname;
        this.targetPostId = targetPostId;
        this.targetReplyId = targetReplyId;
        this.noticeType = noticeType;
        this.content = content;
        this.isRead = isRead;
        this.insertDate = insertDate;
    }
}
