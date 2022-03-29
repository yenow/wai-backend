package com.wai.domain.notice;

import com.wai.domain.common.BaseEntity;
import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.user.User;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.annotation.Nullable;
import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert @DynamicUpdate
public class Notice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_user_id")
    private User recipient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "giver_user_id")
    private User giver;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_post_id")
    private Post targetPost;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_reply_id")
    private Reply targetReply;

    @Enumerated(EnumType.STRING)
    @Column
    private NoticeType noticeType;
    @Column(length = 4000)
    private String content;
    @Builder.Default
    @Column(nullable = false, columnDefinition = "bit(1) default 0")
    private Boolean isRead = false;

    public void clear() {
        this.isRead = true;
    }
}
