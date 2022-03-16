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
    EXPIRED_TOKEN("err-001", "token expired", HttpStatus.UNAUTHORIZED),
    INVALID_TOKEN("err-002","invalid token", HttpStatus.UNAUTHORIZED),

    DUPLICATION_USER_KEY("err-100","userKey duplicate", HttpStatus.BAD_REQUEST),
    DUPLICATION_NICKNAME("err-101","nickname duplicate", HttpStatus.BAD_REQUEST),

    NOT_EXISTED_USER_KEY("err-200","not existed userKey", HttpStatus.BAD_REQUEST),
    NOT_EXISTED_PASSWORD("err-201","not existed password", HttpStatus.BAD_REQUEST),

    NOT_EXISTED_USER_ID("err-202","not existed userId", HttpStatus.BAD_REQUEST),
    NOT_EXISTED_POST_TITLE("err-210","not existed title", HttpStatus.BAD_REQUEST),
    NOT_EXISTED_POST_CONTENT("err-211","not existed content", HttpStatus.BAD_REQUEST),
    NOT_EXISTED_POST_AUTHOR_ENNEAGRAM_TYPE("err-212","not existed author_enneagram_type", HttpStatus.BAD_REQUEST),

    WAI("err-999","WAI", HttpStatus.BAD_REQUEST);

    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    public String toJson() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("status", httpStatus.value());
        map.put("error", httpStatus.getReasonPhrase());
        map.put("errorCode", errorCode);
        map.put("message", message);
        map.put("timestamp", LocalDateTime.now().toString());

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(map);

        return jsonStr;
    }
}
