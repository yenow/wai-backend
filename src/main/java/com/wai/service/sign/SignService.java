package com.wai.service.sign;

import com.wai.common.exception.sign.PasswordNotEqualException;
import com.wai.common.exception.sign.UserNotExistException;
import com.wai.common.exception.user.UserKeyDuplicationException;
import com.wai.common.exception.user.UserNicknameDuplicationException;
import com.wai.controller.sign.dto.SignRequestDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.controller.user.dto.UserRequestDto;
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


    public void signIn(SignRequestDto signRequestDto) {
        User user = userRepository.findOneWithAuthoritiesByUsername(signRequestDto.getUsername())
                .orElseThrow(() -> { throw new UserNotExistException(); });

        System.out.println(passwordEncoder.encode(signRequestDto.getPassword()));
        System.out.println(user.getPassword());

        if (!passwordEncoder.matches(signRequestDto.getPassword(),user.getPassword())) {
            throw new PasswordNotEqualException();
        }
    }

    @Transactional
    public UserDto signUpAsNonMember(SignRequestDto signRequestDto) {
        if(isUserKeyDuplicated(signRequestDto)) throw new UserKeyDuplicationException();
        if(isNicknameDuplicated(signRequestDto)) throw new UserNicknameDuplicationException();

        User user = User.builder()
                .userKey(signRequestDto.getUserKey())
                .password(passwordEncoder.encode(signRequestDto.getPassword()))
                .nickname(signRequestDto.getNickname())
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

    private boolean isUserKeyDuplicated(SignRequestDto signRequestDto) {
        return userRepository.findByUserKey(signRequestDto.getUserKey()).isPresent();
    }

    public UserDto signInByUserKey(SignRequestDto signRequestDto) {
        User user = userRepository.findByUserKey(signRequestDto.getUserKey())
                .orElse(User.builder().build());

        return user.toDto()
                .setUserRoleDtos(user.getUserRoles());
    }

    private boolean isNicknameDuplicated(SignRequestDto signRequestDto) {
        return userRepository.findByNickname(signRequestDto.getNickname()).isPresent();
    }
}
