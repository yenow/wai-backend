package com.wai.service.login;

import com.wai.controller.login.dto.LoginRequestDto;
import com.wai.controller.login.dto.LoginResponseDto;
import com.wai.controller.dto.SimpleLoginRequestDto;

import javax.servlet.http.HttpSession;

/**
 * packageName : com.wai.service.login
 * fileName : LoginService
 * author : 윤신영
 * date : 2021-12-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-22   윤신영     최초 생성
 */
public interface LoginService {
    public void checkLogin(LoginRequestDto loginRequestDto, LoginResponseDto loginResponseDto, HttpSession session);

    LoginResponseDto simpleLogin(SimpleLoginRequestDto simpleLoginRequestDto, HttpSession httpSession);

    Long saveUserKey(String userKey);

    void registerSession(LoginRequestDto loginRequestDto, HttpSession session);
}
