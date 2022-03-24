package com.wai.service.user;

import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.common.exception.user.UserKeyTooLongException;
import com.wai.common.exception.user.UserNicknameDuplicationException;
import com.wai.common.exception.user.UserNotExistException;
import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.fileUpload.FileUpload;
import com.wai.domain.fileUpload.FileUploadRepository;
import com.wai.dto.enneagramTest.EnneagramTestDto;
import com.wai.dto.fileUpload.FileUploadDto;
import com.wai.dto.user.UserRequestDto;
import com.wai.dto.user.UserDto;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import com.wai.service.FileWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {


    final UserRepository userRepository;
    final FileUploadRepository fileUploadRepository;
    final UserServiceUtil userServiceUtil;
    final FileWriter fileWriter;

    public UserDto getUserInformation(UserRequestDto userRequestDto) {
        User user = userRepository.getUserInformation(userRequestDto).orElseThrow(UserNotExistException::new);
        return new UserDto(user);
    }

    public List<EnneagramTestDto> getUserEnneagramTests(UserRequestDto userRequestDto) {
        List<EnneagramTest> enneagramTests = userRepository.getUserEnneagramTests(userRequestDto.getUserKey());
        return enneagramTests.stream().map(EnneagramTestDto::new).collect(Collectors.toList());
    }

    @Transactional
    public UserDto updateUser(UserRequestDto userRequestDto, MultipartFile multipartFile) {
        if (userServiceUtil.isNicknameDuplicated(userRequestDto)) throw new UserNicknameDuplicationException();

        User user = userRepository.findByUserId(userRequestDto.getUserId()).orElseThrow(UserNotExistException::new);

        if (!user.getNickname().equals(userRequestDto.getNickname())) {
            user.updateUser(userRequestDto);
        }

        if (!multipartFile.isEmpty()) {
            FileUpload profileImage = fileWriter.getFileUpload(multipartFile);
            fileUploadRepository.save(profileImage);
            user.updateProfileImage(profileImage);
        }

        return new UserDto(user);
    }


    @Transactional
    public UserDto saveNickname(UserRequestDto userRequestDto) {
        if (isNicknameDuplicated(userRequestDto)) throw new UserNicknameDuplicationException();

        User user = userRepository.findByUserId(userRequestDto.getUserId()).get();
        user.saveNickname(userRequestDto.getNickname());

        return user.toDto();
    }






    private boolean isNicknameDuplicated(UserRequestDto userRequestDto) {
        return userRepository.findByNickname(userRequestDto.getNickname()).isPresent();
    }

    @Deprecated
    public Long saveUserKey(String userKey) {
        if (StringUtils.isBlank(userKey)) {
            throw new UserKeyNotExistException();
        } else if (userKey.getBytes(StandardCharsets.UTF_8).length > 200) {
            throw new UserKeyTooLongException();
        }

        return userRepository.save(User.builder().userKey(userKey).build()).getUserId();
    }
}
