package com.wai.service;

import com.wai.dto.enneagramTest.EnneagramTestRequestDto;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.enneagramTest.EnneagramTestRepository;
import com.wai.domain.user.User;
import com.wai.domain.userEnneagramTest.UserEnneagramTest;
import com.wai.domain.userEnneagramTest.UserEnneagramTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class EnneagramTestService {

    private final EnneagramTestRepository enneagramTestRepository;
    private final UserEnneagramTestRepository userEnneagramTestRepository;

    public EnneagramTest doSelectedEnneagramTestResult (EnneagramTestRequestDto enneagramTestRequestDto) {
        EnneagramTest enneagramTest = enneagramTestRepository.save(enneagramTestRequestDto.toEntity());

        UserEnneagramTest userEnneagramTest = UserEnneagramTest.builder()
                .user(User.builder().userId(enneagramTestRequestDto.getUserId()).build())
                .enneagramTest(enneagramTest)
                .build();

        userEnneagramTestRepository.save(userEnneagramTest);
        return enneagramTest;
    }

    public EnneagramTest doSimpleEnneagramTestResult(EnneagramTestRequestDto enneagramTestRequestDto) {
        enneagramTestRequestDto.calculateSimpleEnneagramTest();
        EnneagramTest enneagramTest = enneagramTestRepository.save(enneagramTestRequestDto.toEntity());

        UserEnneagramTest userEnneagramTest = UserEnneagramTest.builder()
                .user(User.builder().userId(enneagramTestRequestDto.getUserId()).build())
                .enneagramTest(enneagramTest)
                .build();

        userEnneagramTestRepository.save(userEnneagramTest);
        return enneagramTest;
    }

    public EnneagramTest doHardEnneagramTestResult(EnneagramTestRequestDto enneagramTestRequestDto) {
        enneagramTestRequestDto.calculateHardEnneagramTest();
        
        EnneagramTest enneagramTest = enneagramTestRepository.save(enneagramTestRequestDto.toEntity());

        UserEnneagramTest userEnneagramTest = UserEnneagramTest.builder()
                .user(User.builder().userId(enneagramTestRequestDto.getUserId()).build())
                .enneagramTest(enneagramTest)
                .build();

        userEnneagramTestRepository.save(userEnneagramTest);
        return enneagramTest;
    }
}
