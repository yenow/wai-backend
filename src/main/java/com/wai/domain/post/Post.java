package com.wai.domain.post;

import com.wai.common.BaseEntity;
import com.wai.domain.reply.Reply;
import com.wai.domain.tag.Tag;
import com.wai.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Reply> replys = new ArrayList<Reply>();;
    @OneToMany(mappedBy = "post")
    private List<Tag> tags = new ArrayList<Tag>();

    @Column(length = 300, nullable = false)
    private String title;
    @Column(length = 4000, nullable = false)
    private String content;
    @Column
    private int clickCount;
    @Column
    private boolean isDelete;

    @Builder

    public Post(Long postId, User user, List<Reply> replys, List<Tag> tags, String title, String content, int clickCount, boolean isDelete) {
        this.postId = postId;
        this.user = user;
        this.replys = replys;
        this.tags = tags;
        this.title = title;
        this.content = content;
        this.clickCount = clickCount;
        this.isDelete = isDelete;
    }
}
