package com.wai.controller.dto;

import com.wai.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * packageName : com.wai.web.dto
 * fileName : PostSaveRequestDto
 * author : 윤신영
 * date : 2021-12-03
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-03   윤신영     최초 생성
 */
@Getter
@Builder
@ToString
@NoArgsConstructor
public class PostSaveRequestDto {

    private String content;

    @Builder
    public PostSaveRequestDto(String content) {
        this.content = content;
    }

    public Post toEntity() {
        return Post.builder().content(content).build();
    }
}
