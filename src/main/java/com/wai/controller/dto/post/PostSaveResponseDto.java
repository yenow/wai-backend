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
public class PostSaveResponseDto {

    private Boolean isSuccess;
    private String errorMessage;
    private Long postId;

    @Builder
    public PostSaveResponseDto(Boolean isSuccess, String errorMessage, Long postId) {
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
        this.postId = postId;
    }

    public Post toEntity() {
        Post post = new Post();
        return post;
    }
}
