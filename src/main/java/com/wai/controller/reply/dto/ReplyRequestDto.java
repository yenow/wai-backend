package com.wai.controller.reply.dto;

import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.user.User;
import lombok.*;


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
    private String replyContent;

    public Reply toEntity() {
        return Reply.builder()
                .replyId(replyId)
                .user(User.builder().userId(userId).build())
                .post(Post.builder().postId(postId).build())
                .parentReplyId(parentReplyId)
                .replyContent(replyContent)
                .build();
    }
}
