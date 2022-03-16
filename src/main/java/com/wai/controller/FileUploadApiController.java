    package com.wai.controller;

import com.wai.dto.fileUpload.FileUploadDto;
import com.wai.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping ("/image")
    public List<FileUploadDto> createImage(@RequestPart("imageFile") MultipartFile[] multipartFiles
        ,@RequestParam("userKey") String userKey, @RequestParam("userId") String userId) {

        log.info("userKey:: {}", userKey);
        log.info("userId:: {}", userId);
        List<FileUploadDto> fileUploadDtos = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            FileUploadDto fileUploadDto = fileUploadService.upload(multipartFile);
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

}
