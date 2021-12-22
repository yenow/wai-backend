package com.wai.domain.tag;

import com.wai.common.BaseEntity;
import com.wai.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * packageName : com.wai.domain.tag
 * fileName : Tag
 * author : 윤신영
 * date : 2021-12-21
 * description : 태그 엔티티
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-21   윤신영     최초 생성
 */
@Getter
@Builder
@NoArgsConstructor
@Entity
public class Tag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column
    private String tagName;

    @Builder
    public Tag(Long tagId, Post post, String tagName) {
        this.tagId = tagId;
        this.post = post;
        this.tagName = tagName;
    }
}
