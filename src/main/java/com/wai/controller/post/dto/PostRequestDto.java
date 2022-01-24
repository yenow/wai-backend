package com.wai.controller.post.dto;

import lombok.*;

/**
 * packageName : com.wai.controller.dto.post
 * fileName : PostRequestDto
 * author : 윤신영
 * date : 2022-01-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-22   윤신영     최초 생성
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {

    private Long postId;
    private int postsCount;
    private Long startPostId;
    private Long LastPostId;
}
