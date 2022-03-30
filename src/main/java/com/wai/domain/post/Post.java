package com.wai.domain.post;

import com.wai.domain.common.BaseEntity;
import com.wai.dto.post.PostDto;
import com.wai.dto.post.PostSaveRequestDto;
import com.wai.dto.reply.ReplyDto;
import com.wai.domain.likey.Likey;
import com.wai.domain.reply.Reply;
import com.wai.domain.tag.Tag;
import com.wai.domain.user.User;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Builder @NoArgsConstructor @AllArgsConstructor @ToString(exclude = {"user", "replys", "likeys", "tags"})
@DynamicInsert @DynamicUpdate
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id")
    private User user;

    @Builder.Default
    @OneToMany(mappedBy = "post")
    private List<Reply> replys = new ArrayList<Reply>();;
    @Builder.Default
    @OneToMany(mappedBy = "post")
    private List<Likey> likeys = new ArrayList<>();
    @Builder.Default
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Tag> tags = new ArrayList<>();


    @Column(length = 300, nullable = false)
    private String title;
    @Column(length = 4000, nullable = false)
    private String content;
    @Column(length = 200)
    private String author;
    @Column
    private Integer authorEnneagramType;
    @Column(length = 200)
    private String backgroundImageName;
    @Builder.Default
    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer clickCount = 0;
    @Builder.Default
    @Column(nullable = false, columnDefinition = "bit(1) default 0")
    private Boolean isDeleted = false;
    @Builder.Default
    @Column(nullable = false, columnDefinition = "bit(1) default 0")
    private Boolean isReported = false;

    public void increaseClickCount() {
        clickCount = clickCount + 1;
    }

    public void deletePost() { isDeleted = true; }

    public void updatePost(PostSaveRequestDto postSaveRequestDto) {
        title = postSaveRequestDto.getTitle();
        content = postSaveRequestDto.getContent();
    }

    public void updateTags(List<Tag> tags) {
        tags.forEach(tag -> tag.setPost(this));
        this.tags = tags;
    }

    public void reportPost() { isReported = true; }
}
