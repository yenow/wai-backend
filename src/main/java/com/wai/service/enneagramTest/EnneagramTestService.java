package com.wai.service.enneagramTest;

import com.wai.controller.enneagramTest.dto.EnneagramTestRequestDto;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.enneagramTest.EnneagramTestRepository;
import com.wai.domain.user.User;
import com.wai.domain.userEnneagramTest.UserEnneagramTest;
import com.wai.domain.userEnneagramTest.UserEnneagramTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName : com.wai.service.enneagramTest
 * fileName : EnneagramTestService
 * author : 윤신영
 * date : 2022-01-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-22   윤신영     최초 생성
 */
@RequiredArgsConstructor
@Service
public class EnneagramTestService {

    private final EnneagramTestRepository enneagramTestRepository;
    private final UserEnneagramTestRepository userEnneagramTestRepository;

    public EnneagramTest saveSelectEnneagramTestResult (EnneagramTestRequestDto enneagramTestRequestDto) {
        EnneagramTest enneagramTest = enneagramTestRepository.save(enneagramTestRequestDto.toEntity());

        UserEnneagramTest userEnneagramTest = UserEnneagramTest.builder()
                .user(User.builder().userId(enneagramTestRequestDto.getUserId()).build())
                .enneagramTest(enneagramTest)
                .build();

        userEnneagramTestRepository.save(userEnneagramTest);
        return enneagramTest;
    }

    public EnneagramTest saveSimpleEnneagramTestResult(EnneagramTestRequestDto enneagramTestRequestDto) {
        enneagramTestRequestDto.CalculateSimpleEnneagramTest();
        EnneagramTest enneagramTest = enneagramTestRepository.save(enneagramTestRequestDto.toEntity());

        UserEnneagramTest userEnneagramTest = UserEnneagramTest.builder()
                .user(User.builder().userId(enneagramTestRequestDto.getUserId()).build())
                .enneagramTest(enneagramTest)
                .build();

        userEnneagramTestRepository.save(userEnneagramTest);
        return enneagramTest;
    }

    public EnneagramTest saveHardEnneagramTestResult(EnneagramTestRequestDto enneagramTestRequestDto) {
        // 타입을 결정하는 로직필요
        
        EnneagramTest enneagramTest = enneagramTestRepository.save(enneagramTestRequestDto.toEntity());

        UserEnneagramTest userEnneagramTest = UserEnneagramTest.builder()
                .user(User.builder().userId(enneagramTestRequestDto.getUserId()).build())
                .enneagramTest(enneagramTest)
                .build();

        userEnneagramTestRepository.save(userEnneagramTest);
        return enneagramTest;
    }
}
