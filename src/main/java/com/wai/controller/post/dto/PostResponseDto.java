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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto extends  ResponseDto {
    private Long postId;
    private String title;
    private String content;
    private String author;
    private Integer authorEnneagramType;
    private int clickCount;
    private int likeyCount;
    private Boolean isDelete;
    private LocalDateTime insertDate;
    private LocalDateTime updateDate;
    private Long insertId;

    private UserResponseDto user;
    private List<ReplyResponseDto> replys;
    private List<Tag> tags;
    private List<Long> likeys;

    public PostResponseDto setUserDto(UserResponseDto user) {
        this.user = user;
        return this;
    }

    public PostResponseDto setReplyDtos(List<ReplyResponseDto> replys) {
        this.replys = replys;
        return this;
    }
}
