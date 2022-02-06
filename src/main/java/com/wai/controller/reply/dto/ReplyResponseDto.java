package com.wai.controller.reply.dto;

import com.wai.controller.dto.ResponseDto;
import com.wai.controller.post.dto.PostResponseDto;
import com.wai.controller.user.dto.UserResponseDto;
import com.wai.domain.user.User;
import lombok.*;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

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
public class ReplyResponseDto extends ResponseDto {
    private Long replyId;
    private Long parentReplyId;
    private String replyContent;
    private LocalDateTime insertDate;

    private UserResponseDto user;
    private PostResponseDto post;

    public ReplyResponseDto setUserDto(UserResponseDto user) {
        this.user = user;
        return this;
    }

    public ReplyResponseDto setPostDto(PostResponseDto post) {
        this.post = post;
        return this;
    }
}
