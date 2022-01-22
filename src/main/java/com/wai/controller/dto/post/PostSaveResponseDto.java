package com.wai.controller.dto.post;

import com.wai.domain.post.Post;
import lombok.*;

/**
 * packageName : com.wai.controller.dto
 * fileName : PostResponseDto
 * author : 윤신영
 * date : 2022-01-20
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-20   윤신영     최초 생성
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostSaveResponseDto {

    private boolean isSuccess;
    private String errorMessage;
    private Long postId;

    public Post toEntity() {
        Post post = new Post();
        return post;
    }
}
