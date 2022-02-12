package com.wai.domain.wiseSaying;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wai.common.BaseEntity;
import com.wai.domain.enneagram.Enneagram;
import com.wai.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.persistence.*;

/**
 * packageName : com.wai.domain.wiseSaying
 * fileName : WiseSaying
 * author : 윤신영
 * date : 2022-01-26
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-26   윤신영     최초 생성
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WiseSaying extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column
    @Enumerated(EnumType.STRING)
    private WiseSayingCategory wiseSayingCategory;

    @ManyToOne
    @JoinColumn(name = "enneagram_type")
    @JsonBackReference
    private Enneagram enneagram;

    @Column(length = 4000)
    private String wiseSaying;
    @Column
    private String author;
}
