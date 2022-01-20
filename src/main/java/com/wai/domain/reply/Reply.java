package com.wai.domain.reply;

import com.wai.common.BaseEntity;
import com.wai.domain.post.Post;
import com.wai.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * packageName : com.wai.domain.reply
 * fileName : Reply
 * author : 윤신영
 * date : 2022-01-20
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-20   윤신영     최초 생성
 */
@Getter
@Builder
@NoArgsConstructor
@Entity
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column
    private String replyContent;

    @Builder
    public Reply(Long replyId, User user, Post post, String replyContent) {
        this.replyId = replyId;
        this.user = user;
        this.post = post;
        this.replyContent = replyContent;
    }
}
