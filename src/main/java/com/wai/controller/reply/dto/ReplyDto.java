package com.wai.controller.reply.dto;

import com.wai.controller.dto.ResponseDto;
import com.wai.controller.post.dto.PostDto;
import com.wai.controller.user.dto.UserDto;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto extends ResponseDto {
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

    private UserDto user;
    private PostDto post;

    public ReplyDto setUserDto(UserDto user) {
        this.user = user;
        return this;
    }

    public ReplyDto setPostDto(PostDto post) {
        this.post = post;
        return this;
    }
}
