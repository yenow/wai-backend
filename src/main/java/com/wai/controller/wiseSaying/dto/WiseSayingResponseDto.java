package com.wai.controller.wiseSaying.dto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wai.controller.user.dto.UserResponseDto;
import com.wai.domain.enneagram.Enneagram;
import com.wai.domain.user.User;
import com.wai.domain.wiseSaying.WiseSayingCategory;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WiseSayingResponseDto {
    private Long id;
    private UserResponseDto userDto;
    private String wiseSayingCategory;
    private String wiseSaying;
    private String author;
}
