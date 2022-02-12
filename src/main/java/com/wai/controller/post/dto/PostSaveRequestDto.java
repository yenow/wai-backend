package com.wai.controller.post.dto;

import com.wai.domain.post.Post;
import com.wai.domain.user.User;
import lombok.*;

/**
 * packageName : com.wai.controller.dto.post
 * fileName : PostRequestDto
 * author : 윤신영
 * date : 2022-01-20
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-20   윤신영     최초 생성
 */
@Getter
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostSaveRequestDto {

    private Long postId;
    private Long userId;
    private String userKey;
    private String title;
    private String content;
    private String author;
    private Integer authorEnneagramType;

    public Post toEntity() {
        return Post.builder()
                .postId(postId)
                .title(title)
                .content(content)
                .author(author)
                .authorEnneagramType(authorEnneagramType)
                .user(User.builder().userId(userId).userKey(userKey).build())
                .build();
    }
}
