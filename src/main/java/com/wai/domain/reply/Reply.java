package com.wai.domain.reply;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wai.common.BaseEntity;
import com.wai.controller.reply.dto.ReplyResponseDto;
import com.wai.domain.post.Post;
import com.wai.domain.user.User;
import lombok.*;

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
@AllArgsConstructor
@Entity
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;
    @Column
    private Long parentReplyId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private Post post;

    @Column
    private String replyContent;

    public ReplyResponseDto toDto() {
        return ReplyResponseDto.builder()
                .replyId(replyId)
                .parentReplyId(parentReplyId)
                .replyContent(replyContent)
                .insertDate(getInsertDate())
                .build();
    }
}
