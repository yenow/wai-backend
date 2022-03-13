package com.wai.dto.post;

import lombok.*;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {

    private Long postId;
    private Long userId;
    private int postsCount;
    private Long startPostId;
    private Long endPostId;
    private Integer myEnneagramType;
    private PostSearchType postSearchType;
    private String searchText;
    private Boolean canUpdateCount;

}
