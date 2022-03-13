package com.wai.dto.wiseSaying;
import com.wai.dto.user.UserDto;
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
