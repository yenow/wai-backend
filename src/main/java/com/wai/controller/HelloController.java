package com.wai.controller;

import com.wai.controller.dto.HelloRequestDto;
import com.wai.controller.dto.HelloResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        log.debug("/info start");
        System.out.println("/info start");
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

    @GetMapping("/hello/enumTest")
    public HelloResponseDto enumTest(@RequestBody HelloRequestDto helloDto) {
        System.out.println("-------여기----------");
        log.debug(helloDto.toString());
        return new HelloResponseDto(helloDto.getName(), 1);
    }
}

