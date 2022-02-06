package com.wai.controller;

import com.wai.controller.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * packageName : com.wai.controller
 * fileName : ApiController
 * author : 윤신영
 * date : 2022-02-04
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-02-04   윤신영     최초 생성
 */
@RestController
public class ApiController {

    @GetMapping("/api/getServerTime")
    public ResponseDto getServerTime() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setNowServerTime(LocalDateTime.now());
        return responseDto;
    }

}
