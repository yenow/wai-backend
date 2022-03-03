package com.wai.domain.tag;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wai.domain.common.BaseEntity;
import com.wai.domain.post.Post;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column
    private String tagName;
}
