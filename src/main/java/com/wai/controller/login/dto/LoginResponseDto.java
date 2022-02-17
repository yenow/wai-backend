package com.wai.controller.login.dto;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

    private Boolean isLoginSuccess;
    private Boolean isErrorMessage;
    private String errorMessage;
}
