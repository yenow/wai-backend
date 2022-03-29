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
    private String author;
    private Integer authorEnneagramType;
    private String replyContent;

    private Long parentReplyId;
    private Long parentReplyUserId;
    private String parentAuthor;

    private Long userId;
    private Long postId;

    public Reply toEntity() {
        return Reply.builder()
                .replyId(replyId)
                .author(author)
                .authorEnneagramType(authorEnneagramType)
                .replyContent(replyContent)

                .parentReplyId(parentReplyId)
                .parentReplyUserId(parentReplyUserId)
                .parentAuthor(parentAuthor)

                .user(User.builder().userId(userId).build())
                .post(Post.builder().postId(postId).build())
                .build();
    }
}
