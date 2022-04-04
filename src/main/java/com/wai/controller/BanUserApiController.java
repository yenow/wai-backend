package com.wai.controller;

import com.wai.dto.ResponseDto;
import com.wai.dto.banUser.BanUserDto;
import com.wai.dto.banUser.BanUserRequestDto;
import com.wai.service.BanUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BanUserApiController {

    final private BanUserService banUserService;

    @GetMapping("/banUsers/{userId}")
    public List<BanUserDto> getBanUsers(@PathVariable("userId") Long userId) {
        return banUserService.getBanUsers(userId);
    }

    @PostMapping("/banUser/create")
    public BanUserDto createBanUser(@RequestBody BanUserRequestDto banUserRequestDto) {
        return banUserService.createBanUser(banUserRequestDto);
    }

    @DeleteMapping("/banUser/delete")
    public BanUserDto deleteBanUser(@RequestBody BanUserRequestDto banUserRequestDto) {
        return banUserService.deleteBanUser(banUserRequestDto);
    }
}
