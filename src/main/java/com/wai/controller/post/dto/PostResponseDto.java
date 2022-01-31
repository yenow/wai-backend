package com.wai.controller.post.dto;

import com.wai.controller.dto.ResponseDto;
import com.wai.controller.reply.dto.ReplyResponseDto;
import com.wai.controller.user.dto.UserResponseDto;
import com.wai.domain.post.Post;
import com.wai.domain.reply.Reply;
import com.wai.domain.tag.Tag;
import com.wai.domain.user.User;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.wai.controller.dto.post
 * fileName : PostResponseDto
 * author : 윤신영
 * date : 2022-01-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-22   윤신영     최초 생성
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private Long postId;
    private UserResponseDto user;
    private List<ReplyResponseDto> replys;
    private List<Tag> tags;
    private String title;
    private String content;
    private String author;
    private int clickCount;
    private boolean isDelete;

    public PostResponseDto setUserDto(UserResponseDto user) {
        this.user = user;
        return this;
    }

    public PostResponseDto setReplyDtos(List<ReplyResponseDto> replys) {
        this.replys = replys;
        return this;
    }
}
