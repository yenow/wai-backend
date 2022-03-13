package com.wai.domain.reply;

import com.wai.domain.common.BaseEntity;
import com.wai.dto.reply.ReplyDto;
import com.wai.domain.post.Post;
import com.wai.domain.user.User;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter @Builder @NoArgsConstructor @AllArgsConstructor @ToString(exclude = {"user", "post"})
@DynamicInsert @DynamicUpdate
@Entity
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;
    @Column
    private Long parentReplyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column
    private String author;
    @Column
    private String parentAuthor;
    @Column
    private Integer authorEnneagramType;
    @Column
    private String replyContent;
    @Builder.Default
    @Column
    private Boolean isDeleted = false;
    @Builder.Default
    @Column
    private Boolean isReported = false;

    public ReplyDto toDto() {
        return ReplyDto.builder()
                .replyId(replyId)
                .parentReplyId(parentReplyId)
                .author(author)
                .parentAuthor(parentAuthor)
                .authorEnneagramType(authorEnneagramType)
                .replyContent(replyContent)
                .isDeleted(isDeleted)
                .isReported(isReported)
                .insertDate(getInsertDate())
                .updateDate(getUpdateDate())
                .build();
    }

    public void reportReply() {
        this.isReported = true;
    }

    public void deleteReply() { this.isDeleted = true; }
}
