package com.wai.domain.tag;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wai.common.BaseEntity;
import com.wai.domain.post.Post;
import lombok.*;

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
@AllArgsConstructor
@Entity
public class Tag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private Post post;

    @Column
    private String tagName;
}
