package com.wai.config.jwt;

import com.wai.common.util.ErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // 유효한 자격증명을 제공하지 않고 접근하려 할때 401

        String exception = (String)request.getAttribute("exception");
        ErrorCode errorCode;

        if (StringUtils.isEmpty(exception)) {
            return;
        }
        /*
          토큰 만료된 경우
         */
        if(exception.equals(ErrorCode.EXPIRED_TOKEN.getErrorCode())) {
            errorCode = ErrorCode.EXPIRED_TOKEN;
            setResponse(response, errorCode);
            return;
        }

        /*
         * 토큰이 유효하지 않은 경우
         */
        if(exception.equals(ErrorCode.INVALID_TOKEN.getErrorCode())) {
            errorCode = ErrorCode.INVALID_TOKEN;
            setResponse(response, errorCode);
            return;
        }

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

    /**
     * 한글 출력을 위해 getWriter() 사용
     */
    private void setResponse(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(errorCode.getHttpStatus().value());
        response.getWriter().println(errorCode.toJson());
    }
}