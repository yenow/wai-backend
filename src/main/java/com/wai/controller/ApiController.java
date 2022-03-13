package com.wai.controller;

import com.wai.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ApiController {

    @GetMapping("/api/getServerTime")
    public ResponseDto getServerTime() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setNowServerTime(LocalDateTime.now());
        return responseDto;
    }

}
