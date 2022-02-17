package com.wai.controller.reply.dto;

import com.wai.controller.dto.ResponseDto;
import com.wai.controller.post.dto.PostResponseDto;
import com.wai.controller.user.dto.UserResponseDto;
import com.wai.domain.user.User;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyResponseDto extends ResponseDto {
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
