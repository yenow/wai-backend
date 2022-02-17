package com.wai.domain.wiseSaying;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum WiseSayingCategory {
    love, life, study, success, friend, bye, time, effort, challenge, hope, happy
}
