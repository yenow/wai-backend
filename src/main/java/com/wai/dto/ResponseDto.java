package com.wai.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private LocalDateTime nowServerTime = LocalDateTime.now();
}
