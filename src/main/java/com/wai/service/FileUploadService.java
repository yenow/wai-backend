package com.wai.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.wai.domain.fileUpload.FileType;
import com.wai.domain.fileUpload.FileUpload;
import com.wai.domain.fileUpload.FileUploadRepository;
import com.wai.dto.fileUpload.FileUploadDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileUploadService {
    private final FileWriter fileWriter;
    private final FileUploadRepository fileUploadRepository;

    @Transactional
    public FileUploadDto upload(MultipartFile sourceFile, FileType fileType) {
        FileUpload fileUpload = fileType != null ? fileWriter.getFileUpload(sourceFile, fileType) : fileWriter.getFileUpload(sourceFile);
        fileUploadRepository.save(fileUpload);
        return new FileUploadDto(fileUpload);
    }



    public FileUploadDto getImageFile(Long fileId) {
        FileUpload imageFile = fileUploadRepository.findById(fileId).get();
        return new FileUploadDto(imageFile);
    }

    public List<FileUploadDto> getThemes() {
        return fileUploadRepository.findByFileType().stream().map(FileUploadDto::new).collect(Collectors.toList());
    }
}
