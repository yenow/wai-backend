package com.wai.dto.post;

import com.querydsl.core.annotations.QueryProjection;
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
public class PostDto {
    private Long postId;
    private String title;
    private String content;
    private String author;
    private Integer authorEnneagramType;
    private String backgroundImageName;
    private Integer clickCount;
    private Boolean isDeleted;
    private Boolean isReported;
    private LocalDateTime insertDate;
    private LocalDateTime updateDate;

    private Long userId;
    private Long replyCount;
    private Long likeyCount;
    private Boolean isLikey;
    private String tagString;

    @QueryProjection
    public PostDto(Long postId, String title, String content, String author, Integer authorEnneagramType, String backgroundImageName, Integer clickCount, Boolean isDeleted, Boolean isReported, LocalDateTime insertDate, LocalDateTime updateDate, Long userId, Long replyCount, Long likeyCount, Boolean isLikey, String tagString) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.authorEnneagramType = authorEnneagramType;
        this.backgroundImageName = backgroundImageName;
        this.clickCount = clickCount;
        this.isDeleted = isDeleted;
        this.isReported = isReported;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
        this.userId = userId;
        this.replyCount = replyCount;
        this.likeyCount = likeyCount;
        this.isLikey = isLikey;
        this.tagString = tagString;
    }

    
    public PostDto(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.authorEnneagramType = post.getAuthorEnneagramType();
        this.backgroundImageName = post.getBackgroundImageName();
        this.clickCount = post.getClickCount();
        this.isDeleted = post.getIsDeleted();
        this.isReported = post.getIsReported();
        this.insertDate = post.getInsertDate();
        this.updateDate = post.getUpdateDate();

        this.userId = post.getUser().getUserId();
        this.replyCount = (long) post.getReplys().size();
        this.likeyCount = (long) post.getLikeys().size();
        this.tagString = post.getTags().stream().map(tag ->  "#"+tag.getTagName()).collect(Collectors.joining(" "));
    }

/*    public PostDto setUserDto(UserDto user) {
        this.user = user;
        return this;
    }

    public PostDto setReplyDtos(List<Reply> replys) {
        this.replys = replys.stream().map(reply ->
                reply.toDto()
                        .setUserDto(reply.getUser().toDto())
        ).collect(Collectors.toList());
        return this;
    }*/
}
