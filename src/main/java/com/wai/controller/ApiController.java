package com.wai.controller;

import com.wai.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/api/getServerTime")
    public ResponseDto getServerTime() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setNowServerTime(LocalDateTime.now());
        return responseDto;
    }

    @PostMapping("/isValidToken")
    public ResponseEntity<Boolean> isValidToken() {
        return new ResponseEntity(true, HttpStatus.OK);
    }
}
