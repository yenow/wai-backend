package com.wai.domain.follow;

import com.wai.common.BaseEntity;
import com.wai.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;

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
public class Follow extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User followee;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User follower;

    @Builder
    public Follow(Long id, User followee, User follower) {
        this.id = id;
        this.followee = followee;
        this.follower = follower;
    }
}
