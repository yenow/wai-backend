package com.wai.domain.follow;

import com.wai.domain.common.BaseEntity;
import com.wai.domain.user.User;
import lombok.*;

import javax.persistence.*;

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
