package com.wai.domain.user;

import com.wai.controller.dto.LoginRequestDto;

import java.util.List;

/**
 * packageName : com.wai.domain.user
 * fileName : CustomUserRepository
 * author : 윤신영
 * date : 2021-12-21
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-21   윤신영     최초 생성
 */
public interface UserCustomRepository {

    User findByEmail(String id);

    User findByPhoneNumber(String id);
}
