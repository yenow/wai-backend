package com.wai.dto.notice;

import com.wai.domain.notice.NoticeType;
import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.user.User;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NoticeRequestDto {
    private Long noticeId;
    private Long recipientUserId;
    private Integer maxNoticeSize;
    private Long lastNoticeId;
}
