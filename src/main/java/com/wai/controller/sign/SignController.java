package com.wai.controller.sign;

import com.wai.controller.sign.dto.TokenDto;
import com.wai.controller.sign.dto.SignDto;
import com.wai.controller.sign.dto.SignRequestDto;
import com.wai.controller.user.dto.UserDto;
import com.wai.controller.user.dto.UserRequestDto;
import com.wai.jwt.JwtFilter;
import com.wai.jwt.TokenProvider;
import com.wai.service.sign.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/sign")
public class SignController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final SignService signService;

    @PostMapping("/signIn")
    public ResponseEntity<SignDto> signIn(@RequestBody SignRequestDto signRequestDto) {
        signRequestDto.setUsername();

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
        if (StringUtils.isEmpty(signRequestDto.getUserKey())) {
            throw new RuntimeException();       // todo 예외처리 세분화
        } else if(StringUtils.isEmpty(signRequestDto.getPassword())) {
            throw new RuntimeException();       // todo 예외처리 세분화
        }
        signRequestDto.setUsername();

        signService.signUpAsNonMember(signRequestDto);

        String jwt = getJwtToken(signRequestDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(
                SignDto.builder()
                        .token(jwt)
                        .build(),
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
