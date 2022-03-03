package com.wai.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    EXPIRED_TOKEN("err-001", "토큰 만료", HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN("err-002","토큰의 시그니처가 다름", HttpStatus.UNAUTHORIZED);

    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    public String toJson(String path) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("status", httpStatus.value());
        map.put("error", httpStatus.getReasonPhrase());
        map.put("errorCode", errorCode);
        map.put("message", message);
        map.put("timestamp", LocalDateTime.now().toString());
        map.put("path", path);

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(map);

        return jsonStr;
    }
}
