package com.wai.controller.user.dto;

import com.wai.domain.user.User;
import com.wai.domain.userRole.Role;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto {

    private Long id;
    private UserDto user;
    private Role role;
}
