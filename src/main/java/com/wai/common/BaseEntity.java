package com.wai.common;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * packageName : com.wai.common
 * fileName : BaseEntity
 * author : 윤신영
 * date : 2021-12-23
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-23   윤신영     최초 생성
 */
@MappedSuperclass
public abstract class BaseEntity {

    private String insert_id;
    private LocalDateTime insert_date;
    private String update_id;
    private LocalDateTime update_date;
}
