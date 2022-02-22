package com.wai.controller.login;

import com.wai.controller.dto.ResponseDto;
import com.wai.controller.login.dto.LoginRequestDto;
import com.wai.controller.login.dto.LoginResponseDto;
import com.wai.controller.dto.SimpleLoginRequestDto;
import com.wai.service.login.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

//    @PostMapping(value = "/api/registerSession")
//    public ResponseDto registerSession(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {
//        ResponseDto responseDto = new ResponseDto();
//        HttpSession session = request.getSession();
//        loginService.registerSession(loginRequestDto, session);
//
//        return responseDto;
//    }

    @PostMapping(value = "/api/saveUserKey")
    public Long saveUserKey(@RequestBody String userKey) {
        Long userId = loginService.saveUserKey(userKey);
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
