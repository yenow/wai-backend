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
@Setter
@Builder
@ToString
@NoArgsConstructor
public class PostSaveRequestDto {

    private Long userId;
    private String userKey;
    private String title;
    private String content;

    @Builder
    public PostSaveRequestDto(Long userId, String userKey, String title, String content) {
        this.userId = userId;
        this.userKey = userKey;
        this.title = title;
        this.content = content;
    }


    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .user(User.builder().userId(userId).userKey(userKey).build())
                .build();
    }
}
