package com.wai.dto.post;

import com.wai.domain.post.Post;
import com.wai.dto.ResponseDto;
import com.wai.dto.reply.ReplyDto;
import com.wai.dto.user.UserDto;
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
public class PostDto {
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

    public PostDto(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.authorEnneagramType = post.getAuthorEnneagramType();
        this.clickCount = post.getClickCount();
        this.likeyCount = post.getLikeys().size();
        this.isDeleted = post.getIsDeleted();
        this.isReported = post.getIsReported();
        this.insertDate = post.getInsertDate();
        this.updateDate = post.getUpdateDate();
        this.insertId = post.getInsertId();
    }

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
