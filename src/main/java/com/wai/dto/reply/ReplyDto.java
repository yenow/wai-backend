package com.wai.dto.reply;

import com.wai.domain.reply.Reply;
import com.wai.dto.ResponseDto;
import com.wai.dto.post.PostDto;
import com.wai.dto.user.UserDto;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {
    private Long replyId;
    private String author;
    private Integer authorEnneagramType;
    private String replyContent;

    private Long parentReplyId;
    private Long parentReplyUserId;
    private String parentAuthor;

    private Boolean isDeleted;
    private Boolean isReported;
    private LocalDateTime insertDate;
    private LocalDateTime updateDate;

    private Long userId;
    private Long postId;

    public ReplyDto(Reply reply) {
        this.replyId = reply.getReplyId();
        this.author = reply.getAuthor();
        this.authorEnneagramType = reply.getAuthorEnneagramType();
        this.replyContent = reply.getReplyContent();

        this.parentReplyId = reply.getParentReplyId();
        this.parentAuthor = reply.getParentAuthor();
        this.parentReplyUserId = reply.getParentReplyUserId();

        this.isDeleted = reply.getIsDeleted();
        this.isReported = reply.getIsReported();
        this.insertDate = reply.getInsertDate();
        this.updateDate = reply.getUpdateDate();

        this.userId = reply.getUser().getUserId();
        this.postId = reply.getPost().getPostId();
    }
}
