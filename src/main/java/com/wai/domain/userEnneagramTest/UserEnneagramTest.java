package com.wai.domain.userEnneagramTest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * packageName : com.wai.domain.userEnneagramTest
 * fileName : UserEnneagramTest
 * author : 윤신영
 * date : 2022-01-21
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-21   윤신영     최초 생성
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEnneagramTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "test_id")
    @JsonBackReference
    private EnneagramTest enneagramTest;
}
