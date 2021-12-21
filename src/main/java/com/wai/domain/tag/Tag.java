package com.wai.domain.tag;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Tag {

    @Id
    private Long tagId;

    @Column
    private Long postId;

    @Column
    private String tagName;

    @Builder
    public Tag(Long tagId, Long postId, String tagName) {
        this.tagId = tagId;
        this.postId = postId;
        this.tagName = tagName;
    }
}
