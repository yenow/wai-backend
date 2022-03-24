package com.wai.controller;

import com.wai.domain.fileUpload.FileType;
import com.wai.dto.fileUpload.FileUploadDto;
import com.wai.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fileUpLoad/")
public class FileUploadApiController {

    private final FileUploadService fileUploadService;

    @PostMapping("/images")
    public List<FileUploadDto> uploadImage(@RequestPart("imageFile") MultipartFile[] multipartFiles, @RequestParam("fileType") String fileType) {
        // todo fileType 값에 대한 검증 필요 (없는 값이면 IllegalArgumentException 발생)
        FileType fileTypeTemp = StringUtils.isEmpty(fileType) ? null : FileType.valueOf(fileType);

        List<FileUploadDto> fileUploadDtos = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            FileUploadDto fileUploadDto = fileUploadService.upload(multipartFile, fileTypeTemp);
            fileUploadDtos.add(fileUploadDto);
        }

        return fileUploadDtos;
    }

    @GetMapping("/image/{fileId}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long fileId) throws IOException {
        log.info("fileId:: {}", fileId);

        FileUploadDto imageFile = fileUploadService.getImageFile(fileId);

        FileInputStream fileInputStream = new FileInputStream(imageFile.getFilePath());
        byte[] imageByte = fileInputStream.readAllBytes();
        fileInputStream.close();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", imageFile.getMimeType());
        headers.add("Content-Length", String.valueOf(imageByte.length));
        log.info("Content-Type:: {}", imageFile.getMimeType());

        return new ResponseEntity<>(imageByte, headers, HttpStatus.OK);
    }

    @GetMapping("/themes")
    public List<FileUploadDto> getThemes() throws IOException {
        return fileUploadService.getThemes();
    }
}
