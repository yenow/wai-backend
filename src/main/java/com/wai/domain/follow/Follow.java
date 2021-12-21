package com.wai.domain.follow;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * packageName : com.wai.domain.follow
 * fileName : Follow
 * author : 윤신영
 * date : 2021-12-20
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-20   윤신영     최초 생성
 */
@Getter
@Builder
@NoArgsConstructor
@Entity
public class Follow {

    @Id
    public Long id;

    @Column
    public Long followeeID;

    @Column
    public Long followerID;

    @Builder
    public Follow(Long id, Long followeeID, Long followerID) {
        this.id = id;
        this.followeeID = followeeID;
        this.followerID = followerID;
    }
}
