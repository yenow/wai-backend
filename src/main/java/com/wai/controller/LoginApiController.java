package com.wai.controller;

import com.wai.controller.dto.login.LoginRequestDto;
import com.wai.controller.dto.login.LoginResponseDto;
import com.wai.controller.dto.SimpleLoginRequestDto;
import com.wai.service.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * packageName : com.wai.web
 * fileName : LoginController
 * author : 윤신영
 * date : 2021-12-22
 * description : 로그인 컨트롤러
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-22   윤신영     최초 생성
 */
@RequiredArgsConstructor
@RestController
public class LoginApiController {

    private final LoginService loginService;

    @PostMapping(value = "/api/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto
            , HttpServletRequest request) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        HttpSession session = request.getSession();
        loginService.checkLogin(loginRequestDto, loginResponseDto, session);
        return loginResponseDto;
    }

    @PostMapping(value = "/api/saveUserKey")
    public Long saveUserKey(@RequestBody String userKey) {
        Long userId = loginService.saveUserKey(userKey);
        System.out.println(userId);
        return userId;
    }

    @PostMapping(value = "/api/simpleLogin")
    public LoginResponseDto simpleLogin(@RequestBody SimpleLoginRequestDto SimpleLoginRequestDto, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        System.out.println(SimpleLoginRequestDto.toString());
        LoginResponseDto loginResponseDto = loginService.simpleLogin(SimpleLoginRequestDto, httpSession);
        return loginResponseDto;
    }
}
