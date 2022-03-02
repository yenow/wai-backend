package com.wai.domain.user;

import com.wai.controller.user.dto.UserDto;
import com.wai.controller.user.dto.UserRequestDto;

import javax.transaction.Transactional;
import java.util.Optional;


public interface UserCustomRepository {

    Optional<User> findByEmail(String email);

    Optional<User> findByUserKey(String userKey);

    Optional<User> findByNickname(String nickname);

    Optional<User> getUserInformation(UserRequestDto userRequestDto);

    Optional<User> findOneWithAuthoritiesByUsername(String username);

    Optional<UserDto> getUserDtoInformation(UserRequestDto userRequestDto);

    @Transactional
    void deleteByUserKey(String userKey);
}
