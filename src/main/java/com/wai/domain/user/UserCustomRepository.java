package com.wai.domain.user;

import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.dto.user.UserDto;
import com.wai.dto.user.UserRequestDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface UserCustomRepository {

    Optional<User> findByUserId(Long userId);

    Optional<User> findByEmail(String email);

    Optional<User> findByUserKey(String userKey);

    Optional<User> findByNickname(String nickname);

    Optional<User> findByNicknameAndNotUserId(UserRequestDto userRequestDto);

    Optional<User> getUserInformation(UserRequestDto userRequestDto);

    Optional<User> findOneWithAuthoritiesByUsername(String username);

    Optional<UserDto> getUserDtoInformation(UserRequestDto userRequestDto);

    List<EnneagramTest> getUserEnneagramTests(String userKey);

    @Transactional
    void deleteByUserKey(String userKey);

}
