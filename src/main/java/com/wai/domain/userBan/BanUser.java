package com.wai.domain.userBan;


import com.wai.domain.common.BaseEntity;
import com.wai.domain.user.User;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity @Getter @Builder @NoArgsConstructor @AllArgsConstructor
@DynamicUpdate @DynamicInsert
public class BanUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ban_user_id")
    private User banUser;
}
