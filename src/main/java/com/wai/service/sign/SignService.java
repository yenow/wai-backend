package com.wai.service.sign;

import com.wai.controller.sign.dto.SignRequestDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import com.wai.domain.userRole.Role;
import com.wai.domain.userRole.UserRole;
import com.wai.domain.userRole.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class SignService {

    final private UserRepository userRepository;
    final private UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDto signUpAsNonMember(SignRequestDto signRequestDto) {
        if(userRepository.findByUserKey(signRequestDto.getUserKey()).isPresent()) throw new RuntimeException("이미 가입되어 있는 유저입니다.");

        User user = User.builder()
                .userKey(signRequestDto.getUserKey())
                .password(passwordEncoder.encode(signRequestDto.getPassword()))
                .build();
        UserRole userRole = UserRole.builder()
                .user(user)
                .role(Role.ROLE_USER)
                .build();
        user.getUserRoles().add(userRole);

        userRepository.save(user);
        userRoleRepository.save(userRole);

        return user.toDto()
                .setUserRoleDtos(user.getUserRoles());
    }

    public UserDto signInByUserKey(SignRequestDto signRequestDto) {
        User user = userRepository.findByUserKey(signRequestDto.getUserKey())
                .orElse(User.builder().build());

        return user.toDto()
                .setUserRoleDtos(user.getUserRoles());
    }
}
