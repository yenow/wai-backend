package com.wai.dto.fileUpload;

import com.wai.domain.fileUpload.FileUpload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadDto {

    private Long fileId;
    private String fileType;
    private String mimeType;
    private String uploadFileName;
    private String originalFileName;
    private String filePath;
    private Long fileSize;

    public FileUploadDto(FileUpload fileUpload) {
        fileId = fileUpload.getFileId();
        mimeType = fileUpload.getMimeType();
        fileType = fileUpload.getFileType();
        uploadFileName = fileUpload.getUploadFileName();
        originalFileName = fileUpload.getUploadFileName();
        filePath = fileUpload.getFilePath();
        fileSize = fileUpload.getFileSize();
    }
}
