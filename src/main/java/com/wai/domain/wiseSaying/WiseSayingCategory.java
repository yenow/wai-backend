package com.wai.domain.wiseSaying;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * packageName : com.wai.domain.wiseSaying
 * fileName : WiseSayingCategory
 * author : 윤신영
 * date : 2022-02-07
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-02-07   윤신영     최초 생성
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum WiseSayingCategory {
    love, life, study, success, friend, bye, time, effort, challenge, hope
}
