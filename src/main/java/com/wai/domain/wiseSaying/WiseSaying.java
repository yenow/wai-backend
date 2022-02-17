package com.wai.domain.wiseSaying;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wai.common.BaseEntity;
import com.wai.controller.wiseSaying.dto.WiseSayingResponseDto;
import com.wai.domain.enneagram.Enneagram;
import com.wai.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.persistence.*;


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
    private String wiseSayingCategory;

    @Deprecated
    @ManyToOne
    @JoinColumn(name = "enneagram_type")
    @JsonBackReference
    private Enneagram enneagram;

    @Column(length = 4000)
    private String wiseSaying;
    @Column
    private String author;

    public WiseSayingResponseDto toDto() {
        return WiseSayingResponseDto.builder()
                .id(id)
                .wiseSayingCategory(wiseSayingCategory)
                .wiseSaying(wiseSaying)
                .author(author)
                .build();
    }
}
