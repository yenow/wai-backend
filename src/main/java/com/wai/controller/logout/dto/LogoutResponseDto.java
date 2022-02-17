package com.wai.controller.logout.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LogoutResponseDto {

    private Boolean isLogoutSuccess;
    private Boolean isErrorMessage;
    private String errorMessage;
}
