package com.wai.controller.post.dto;

import com.wai.controller.dto.ResponseDto;
import com.wai.controller.reply.dto.ReplyDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.domain.reply.Reply;
import com.wai.domain.tag.Tag;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostDto extends ResponseDto {
    private Long postId;
    private String title;
    private String content;
    private String author;
    private Integer authorEnneagramType;
    private int clickCount;
    private int likeyCount;
    private Boolean isDeleted;
    private Boolean isReported;
    private LocalDateTime insertDate;
    private LocalDateTime updateDate;
    private Long insertId;

    private UserDto user;
    private List<ReplyDto> replys;
    private List<Tag> tags;
    private List<Long> likeys;

    public PostDto setUserDto(UserDto user) {
        this.user = user;
        return this;
    }

    public PostDto setReplyDtos(List<Reply> replys) {
        this.replys = replys.stream().map(reply ->
                reply.toDto()
                        .setUserDto(reply.getUser().toDto())
        ).collect(Collectors.toList());
        return this;
    }
}
