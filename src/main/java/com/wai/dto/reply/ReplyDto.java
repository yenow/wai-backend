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
    private Long parentReplyId;
    private String author;
    private String parentAuthor;
    private Integer authorEnneagramType;
    private String replyContent;
    private Boolean isDeleted;
    private Boolean isReported;
    private LocalDateTime insertDate;
    private LocalDateTime updateDate;

    private Long userId;
    private Long postId;

    public ReplyDto(Reply reply) {
        this.replyId = reply.getReplyId();
        this.parentReplyId = reply.getParentReplyId();
        this.author = reply.getAuthor();
        this.parentAuthor = reply.getParentAuthor();
        this.authorEnneagramType = reply.getAuthorEnneagramType();
        this.replyContent = reply.getReplyContent();
        this.isDeleted = reply.getIsDeleted();
        this.isReported = reply.getIsReported();
        this.insertDate = reply.getInsertDate();
        this.updateDate = reply.getUpdateDate();
        this.userId = reply.getUser().getUserId();
        this.postId = reply.getPost().getPostId();
    }
}
