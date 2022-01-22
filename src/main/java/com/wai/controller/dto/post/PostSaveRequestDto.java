package com.wai.controller.dto.post;

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

    private Long userId;
    private String userKey;
    private String title;
    private String content;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .user(User.builder().userId(userId).userKey(userKey).build())
                .build();
    }
}
