package com.wai.dto.user;

import com.wai.domain.userRole.Role;
import lombok.*;

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
