package com.wai.service.login;

import com.wai.controller.dto.LoginRequestDto;
import com.wai.controller.dto.LoginResponseDto;
import com.wai.controller.dto.SessionDto;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

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
@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserRepository userRepository;

    @Transactional
    public void checkLogin(LoginRequestDto loginRequestDto, LoginResponseDto loginResponseDto, HttpSession session) {

        SessionDto sessionDto = (SessionDto) session.getAttribute("loginSession");

        // 세션을 가지고 있을 경우
        if (sessionDto != null &&
                (sessionDto.getEmail() == loginRequestDto.getId() || sessionDto.getPhoneNumber() == loginRequestDto.getId())) {
            loginResponseDto.setIsLoginSuccess(false);
            loginResponseDto.setIsErrorMessage(false);
            loginResponseDto.setErrorMessage("");
        }

        User user = new User();
        User userByEmail = userRepository.findByEmail(loginRequestDto.getId());
        User userByPhoneNumber = userRepository.findByPhoneNumber(loginRequestDto.getId());

        // 해당하는 아이디가 없을 경우
        if (userByEmail == null && userByPhoneNumber == null) {
            loginResponseDto.setIsLoginSuccess(false);
            loginResponseDto.setIsErrorMessage(true);
            loginResponseDto.setErrorMessage("존재하지 않는 아이디입니다.");

            return ;
        } else if (userByEmail != null) {
            user = userByEmail;
        } else if (userByPhoneNumber != null) {
            user = userByPhoneNumber;
        }

        /* 비밀번호 암호화 필요 */

        // 비밀번호가 틀릴경우 (암호화가 들어가긴해야함)
        if (!loginRequestDto.getPassword().equals(user.getPassword())) {
            loginResponseDto.setIsLoginSuccess(false);
            loginResponseDto.setIsErrorMessage(true);
            loginResponseDto.setErrorMessage("비밀번호가 같지 않습니다.");

            // 로그인 성공
        } else {
            loginResponseDto.setIsLoginSuccess(true);
            loginResponseDto.setIsErrorMessage(false);
            loginResponseDto.setErrorMessage("");

            SessionDto loginSession = new SessionDto();
            loginSession.setSessionByUser(user);
            session.setAttribute("loginSession", loginSession);
        }
    }
}
