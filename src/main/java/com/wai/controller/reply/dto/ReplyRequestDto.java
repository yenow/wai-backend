package com.wai.controller.reply.dto;

import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.user.User;
import lombok.*;

import javax.persistence.Column;


/**
 * packageName : com.wai.controller.reply.dto
 * fileName : ReplyRequestDto
 * author : 윤신영
 * date : 2022-01-24
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-24   윤신영     최초 생성
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyRequestDto {

    private Long replyId;
    private Long parentReplyId;
    private Long userId;
    private Long postId;
    private String author;
    private String parentAuthor;
    private Integer authorEnneagramType;
    private String replyContent;

    public Reply toEntity() {
        return Reply.builder()
                .replyId(replyId)
                .user(User.builder().userId(userId).build())
                .post(Post.builder().postId(postId).build())
                .author(author)
                .parentAuthor(parentAuthor)
                .authorEnneagramType(authorEnneagramType)
                .parentReplyId(parentReplyId)
                .replyContent(replyContent)
                .build();
    }
}
