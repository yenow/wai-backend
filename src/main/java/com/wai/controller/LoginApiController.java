package com.wai.controller;

import com.wai.controller.dto.LoginRequestDto;
import com.wai.controller.dto.LoginResponseDto;
import com.wai.controller.dto.SessionDto;
import com.wai.service.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
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

//        SessionDto sessionDto = (SessionDto) session.getAttribute("loginSession");
//
//        // 세션을 가지고 있을 경우
//        if (sessionDto != null &&
//                (sessionDto.getEmail() == loginRequestDto.getId() || sessionDto.getPhoneNumber() == loginRequestDto.getId())) {
//            loginResponseDto.setIsLoginSuccess(false);
//            loginResponseDto.setIsErrorMessage(false);
//            loginResponseDto.setErrorMessage("");
//        }

        loginService.checkLogin(loginRequestDto, loginResponseDto, session);

        // service
        /* 0. 세션검증
        *  1. id검증
        *  2. 비밀번호검증
        *  3. 세션 넣기
        *  4.  */

        return loginResponseDto;
    }
}
