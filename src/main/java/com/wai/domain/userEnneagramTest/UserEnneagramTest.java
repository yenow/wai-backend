package com.wai.domain.userEnneagramTest;

import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.user.User;
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
@Entity
public class UserEnneagramTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private EnneagramTest enneagramTest;

    @Builder
    public UserEnneagramTest(Long id, User user, EnneagramTest enneagramTest) {
        this.id = id;
        this.user = user;
        this.enneagramTest = enneagramTest;
    }
}
