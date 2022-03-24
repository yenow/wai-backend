package com.wai.domain.fileUpload;

import com.wai.dto.fileUpload.FileUploadDto;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FileUploadCustomRepository {
    List<FileUpload> findByFileType();
}
