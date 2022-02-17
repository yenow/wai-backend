package com.wai.controller.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PostSearchType {
    all, content, title, author, popular, enneagramType, myPosts, myReplyPosts
}
