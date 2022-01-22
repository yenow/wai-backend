package com.wai.controller.dto.post;

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
    private User user;
    private List<Reply> replys = new ArrayList<Reply>();;
    private List<Tag> tags = new ArrayList<Tag>();
    private String title;
    private String content;
    private int clickCount;

    public void setByPost(Post post) {
        this.postId = post.getPostId();
        this.user = post.getUser();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.clickCount = post.getClickCount();
    }

        /*return PostResponseDto.builder()
            .postId(post.getPostId())
            .user(post.getUser())
            .title( post.getTitle())
            .content(post.getContent())
            .clickCount(post.getClickCount())
            .build();*/
}
