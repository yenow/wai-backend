package com.wai.controller;

import com.wai.common.exception.user.UserNotExistException;
import com.wai.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/getServerTime")
    public ResponseDto getServerTime() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setNowServerTime(LocalDateTime.now());
        return responseDto;
    }

    @GetMapping("/errorTest")
    public void errorTest() {
        throw new UserNotExistException();
    }

/*    @PostMapping("/isValidToken")
    public ResponseEntity<Boolean> isValidToken() {
        return new ResponseEntity(true, HttpStatus.OK);
    }*/
}
