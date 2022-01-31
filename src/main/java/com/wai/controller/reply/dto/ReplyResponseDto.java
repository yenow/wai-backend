package com.wai.controller.reply.dto;

import com.wai.controller.post.dto.PostResponseDto;
import com.wai.controller.user.dto.UserResponseDto;
import com.wai.domain.user.User;
import lombok.*;

/**
 * packageName : com.wai.controller.reply.dto
 * fileName : ReplyResponseDto
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
public class ReplyResponseDto {
    private Long replyId;
    private Long parentReplyId;
    private UserResponseDto user;
    private PostResponseDto post;
    private String replyContent;

    public ReplyResponseDto setUserDto(UserResponseDto user) {
        this.user = user;
        return this;
    }

    public ReplyResponseDto setPostDto(PostResponseDto post) {
        this.post = post;
        return this;
    }
}
