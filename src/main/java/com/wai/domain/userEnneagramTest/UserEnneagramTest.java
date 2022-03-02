package com.wai.domain.userEnneagramTest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wai.domain.common.BaseEntity;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Getter @Builder @NoArgsConstructor @AllArgsConstructor @ToString(exclude = {"user", "enneagramTest"})
@Entity
public class UserEnneagramTest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    @JsonBackReference
    private EnneagramTest enneagramTest;
}
