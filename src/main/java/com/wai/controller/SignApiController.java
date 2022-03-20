package com.wai.controller;

import com.wai.common.exception.sign.PasswordNotExistException;
import com.wai.common.exception.sign.UserNicknameNotExistException;
import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.dto.sign.SignDto;
import com.wai.dto.sign.SignRequestDto;
import com.wai.dto.user.UserRequestDto;
import com.wai.config.jwt.JwtFilter;
import com.wai.config.jwt.TokenProvider;
import com.wai.service.SignService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/sign")
public class SignApiController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final SignService signService;

    @PostMapping("/signIn")
    public ResponseEntity<SignDto> signIn(@RequestBody SignRequestDto signRequestDto) {
        if(StringUtils.isEmpty(signRequestDto.getPassword())) throw new PasswordNotExistException();
        signRequestDto.setUsername();

        SignDto signDto = signService.signIn(signRequestDto);

        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<>(
                signDto,
                httpHeaders,
                HttpStatus.OK
        );
    }

    @PostMapping("/signUpAsNonMember")
    public SignDto signUpAsNonMember(@RequestBody SignRequestDto signRequestDto) {
        if(StringUtils.isEmpty(signRequestDto.getNickname())) throw new UserNicknameNotExistException();

        return signService.signUpAsNonMember(signRequestDto);
    }

    @PostMapping(value ="/signUpByNaver")
    public SignDto signUpByNaver(@RequestBody UserRequestDto userRequestDto) {
        return SignDto.builder().build();
    }

}
