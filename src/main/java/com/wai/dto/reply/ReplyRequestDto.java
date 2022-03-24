package com.wai.dto.reply;

import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.user.User;
import lombok.*;

import javax.persistence.Column;



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
                .replyContent(replyContent)
                .authorEnneagramType(authorEnneagramType)
                .parentReplyId(parentReplyId)
                .parentAuthor(parentAuthor)
                .build();
    }
}
