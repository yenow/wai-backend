package com.wai.domain.userEnneagramTest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wai.common.BaseEntity;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEnneagramTest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    @JsonBackReference
    private EnneagramTest enneagramTest;
}
