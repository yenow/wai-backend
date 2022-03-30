package com.wai.dto.post;

import com.wai.common.exception.post.PostAuthorEnneagramTypeNotExistException;
import com.wai.common.exception.user.UserIdNotExistException;
import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.domain.post.Post;
import com.wai.domain.tag.Tag;
import com.wai.domain.user.User;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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
    private String tag;
    private String author;
    private Integer authorEnneagramType;
    private String backgroundImageName;

    public Post toEntity() {
        return Post.builder()
                .postId(postId)
                .title(title)
                .content(content)
                .author(author)
                .authorEnneagramType(authorEnneagramType)
                .backgroundImageName(backgroundImageName)
                .user(User.builder().userId(userId).userKey(userKey).build())
                .build();
    }

    public void checkValue() {
        if (userId == null) {
            throw new UserIdNotExistException();
        } else if (userKey == null) {
            throw new UserKeyNotExistException();
        } else if (authorEnneagramType == null) {
            throw new PostAuthorEnneagramTypeNotExistException();
        }
    }
}
