package com.wai.domain.wiseSaying;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wai.domain.common.BaseEntity;
import com.wai.controller.wiseSaying.dto.WiseSayingResponseDto;
import com.wai.domain.enneagram.Enneagram;
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
public class WiseSaying extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String wiseSayingCategory;

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
