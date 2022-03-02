package com.wai.service.login;

import com.wai.controller.login.dto.LoginRequestDto;
import com.wai.controller.login.dto.LoginResponseDto;
import com.wai.controller.dto.SessionDto;
import com.wai.controller.dto.SimpleLoginRequestDto;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

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
        User userByEmail = userRepository.findByEmail(loginRequestDto.getId()).get();

        // 해당하는 아이디가 없을 경우
        if (userByEmail == null) {
            loginResponseDto.setIsLoginSuccess(false);
            loginResponseDto.setIsErrorMessage(true);
            loginResponseDto.setErrorMessage("존재하지 않는 아이디입니다.");

            return ;
        } else if (userByEmail != null) {
            user = userByEmail;
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

    @Override
    public LoginResponseDto simpleLogin(SimpleLoginRequestDto simpleLoginRequestDto, HttpSession httpSession) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        
        User user = User.builder()
                .userKey(simpleLoginRequestDto.getUserKey())
                .nickname(simpleLoginRequestDto.getNickname())
                .build();

        try {
            userRepository.save(user);
            
        } catch (Exception e) {
            e.printStackTrace();
            loginResponseDto.setIsLoginSuccess(false);
            loginResponseDto.setIsErrorMessage(true);
            loginResponseDto.setErrorMessage("error 발생");
            
        } finally {
            // 세션을 넣어야함

            loginResponseDto.setIsLoginSuccess(true);
            loginResponseDto.setIsErrorMessage(false);
            loginResponseDto.setErrorMessage("");
        }
        return loginResponseDto;
    }

    @Override
    public Long saveUserKey(String userKey) {
        return userRepository.save(User.builder().userKey(userKey).build()).getUserId();
    }

    @Override
    public void registerSession(LoginRequestDto loginRequestDto, HttpSession session) {

    }
}
