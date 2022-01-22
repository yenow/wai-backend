package com.wai.domain.follow;

import com.wai.common.BaseEntity;
import com.wai.domain.user.User;
import lombok.*;
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
@AllArgsConstructor
@Entity
public class Follow extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn
    public User followee;

    @ManyToOne
    @JoinColumn
    public User follower;
}
