package com.wai.controller.wiseSaying.dto;
import com.wai.controller.user.dto.UserDto;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WiseSayingResponseDto {
    private Long id;
    private UserDto userDto;
    private String wiseSayingCategory;
    private String wiseSaying;
    private String author;
}
