package com.wai.domain.fileUpload;

import com.wai.dto.fileUpload.FileUploadDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long>, FileUploadCustomRepository {
}
