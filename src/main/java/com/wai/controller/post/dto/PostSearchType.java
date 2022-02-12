package com.wai.controller.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * packageName : com.wai.controller.post.dto
 * fileName : PostSearchType
 * author : 윤신영
 * date : 2022-02-07
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-02-07   윤신영     최초 생성
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PostSearchType {
    all, content, title, author, popular, enneagramType
}
