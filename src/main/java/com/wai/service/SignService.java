package com.wai.service;

import com.wai.common.exception.sign.PasswordNotEqualException;
import com.wai.common.exception.sign.UserNotExistException;
import com.wai.common.exception.user.UserKeyDuplicationException;
import com.wai.common.exception.user.UserNicknameDuplicationException;
import com.wai.config.jwt.TokenProvider;
import com.wai.dto.sign.SignDto;
import com.wai.dto.sign.SignRequestDto;
import com.wai.dto.user.UserDto;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import com.wai.domain.userRole.Role;
import com.wai.domain.userRole.UserRole;
import com.wai.domain.userRole.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class SignService {

    final private UserRepository userRepository;
    final private UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;


    public SignDto signIn(SignRequestDto signRequestDto) {
        User user = userRepository.findOneWithAuthoritiesByUsername(signRequestDto.getUsername())
                .orElseThrow(() -> { throw new UserNotExistException(); });

        if (!passwordEncoder.matches(signRequestDto.getPassword(),user.getPassword())) {
            throw new PasswordNotEqualException();
        }

        String jwt = getJwtToken(signRequestDto.getUsername(), signRequestDto.getPassword());

        return SignDto.builder()
                .userId(user.getUserId())
                .userKey(user.getUserKey())
                .password(signRequestDto.getPassword())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .token(jwt)
                .build();
    }

    @Transactional
    public SignDto signUpAsNonMember(SignRequestDto signRequestDto) {
        if(isNicknameDuplicated(signRequestDto)) throw new UserNicknameDuplicationException();

        String createUserKey = UUID.randomUUID().toString();
        String createPassword = UUID.randomUUID().toString();

        User user = User.builder()
                .userKey(createUserKey)       // signRequestDto.getUserKey()
                .password(passwordEncoder.encode(createPassword))     // signRequestDto.getPassword()
                .nickname(signRequestDto.getNickname())
                .isActivated(true)
                .isMember(false)
                .build();
        userRepository.save(user);

        UserRole userRole = UserRole.builder()
                .user(user)
                .role(Role.ROLE_USER)
                .build();
        user.getUserRoles().add(userRole);
        userRoleRepository.save(userRole);

        String jwt = getJwtToken(createUserKey,createPassword);

        return SignDto.builder()
                .userId(user.getUserId())
                .userKey(createUserKey)
                .password(createPassword)
                .nickname(user.getNickname())
                .token(jwt)
                .build();
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

    private String getJwtToken(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);     // loadUserByUsername()
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return tokenProvider.createToken(authentication);
    }
}
