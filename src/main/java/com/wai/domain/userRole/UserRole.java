package com.wai.domain.userRole;

import com.wai.dto.user.UserRoleDto;
import com.wai.domain.user.User;
import lombok.*;

import javax.persistence.*;


@Getter @Builder @NoArgsConstructor @AllArgsConstructor @ToString(exclude = "user")
@Entity
public class UserRole{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 200, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserRoleDto toDto() {
        return UserRoleDto.builder()
                .id(id)
                .role(role)
                .build();
    }
}
