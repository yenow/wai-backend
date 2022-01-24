package com.wai.controller.logout;

import com.wai.controller.logout.dto.LogoutResponseDto;
import com.wai.controller.dto.SessionDto;
import com.wai.service.logout.LogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * packageName : com.wai.web
 * fileName : LogoutController
 * author : 윤신영
 * date : 2021-12-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-22   윤신영     최초 생성
 */
@RequiredArgsConstructor
@RestController
public class LogoutApiController {

    private final LogoutService logoutService;

    @RequestMapping("/api/logout")
    public LogoutResponseDto logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        LogoutResponseDto logoutResponseDto = new LogoutResponseDto();

        SessionDto sessionDto = (SessionDto) session.getAttribute("loginSession");
        logoutService.test();

        if (sessionDto != null) {
            session.removeAttribute("loginSession");
            logoutResponseDto.setIsLogoutSuccess(true);
            logoutResponseDto.setIsErrorMessage(false);
            logoutResponseDto.setErrorMessage("");

        } else {
            logoutResponseDto.setIsLogoutSuccess(false);
            logoutResponseDto.setIsErrorMessage(true);
            logoutResponseDto.setErrorMessage("이미 로그아웃 되었습니다.");
        }

        return logoutResponseDto;
    }
}
