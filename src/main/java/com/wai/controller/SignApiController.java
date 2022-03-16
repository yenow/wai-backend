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

        signService.signIn(signRequestDto);

        String jwt = getJwtToken(signRequestDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(
                SignDto.builder().token(jwt).build(),
                httpHeaders,
                HttpStatus.OK
        );
    }

    @PostMapping("/signUpAsNonMember")
    public ResponseEntity<SignDto> signUpAsNonMember(@RequestBody SignRequestDto signRequestDto) {
        if (StringUtils.isEmpty(signRequestDto.getUserKey())) throw new UserKeyNotExistException();
        else if(StringUtils.isEmpty(signRequestDto.getPassword())) throw new PasswordNotExistException();
        else if(StringUtils.isEmpty(signRequestDto.getNickname())) throw new UserNicknameNotExistException();

        signRequestDto.setUsername();

        SignDto signDto = signService.signUpAsNonMember(signRequestDto);

        String jwt = getJwtToken(signRequestDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        signDto.setToken(jwt);

        return new ResponseEntity<>(
                signDto,
                httpHeaders,
                HttpStatus.OK
        );
    }

    @PostMapping(value ="/signUpByNaver")
    public SignDto signUpByNaver(@RequestBody UserRequestDto userRequestDto) {
        return SignDto.builder().build();
    }

    private String getJwtToken(@RequestBody SignRequestDto signRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(signRequestDto.getUsername(), signRequestDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);     // loadUserByUsername()
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return tokenProvider.createToken(authentication);
    }
}
