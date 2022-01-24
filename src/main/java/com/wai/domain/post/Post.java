package com.wai.domain.post;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wai.common.BaseEntity;
import com.wai.controller.post.dto.PostResponseDto;
import com.wai.domain.reply.Reply;
import com.wai.domain.tag.Tag;
import com.wai.domain.user.User;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.wai.domain.posts
 * fileName : Post
 * author : 윤신영
 * date : 2021-12-02
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-02   윤신영     최초 생성
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "post")
    @JsonManagedReference
    private List<Reply> replys = new ArrayList<Reply>();;
    @OneToMany(mappedBy = "post")
    @JsonManagedReference
    private List<Tag> tags = new ArrayList<Tag>();

    @Column(length = 300, nullable = false)
    private String title;
    @Column(length = 4000, nullable = false)
    private String content;
    @Column(length = 200)
    private String author;
    @Column(columnDefinition = "int default 0")
    private int clickCount;
    @Column
    private boolean isDelete;

    public PostResponseDto toDto() {
        return PostResponseDto.builder()
                .postId(postId)
                .user(user.toDto())
                .title(title)
                .content(content)
                .author(author)
                .clickCount(clickCount)
                .isDelete(isDelete)
                .build();
    }
}
