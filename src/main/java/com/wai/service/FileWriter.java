package com.wai.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.wai.config.PhotoAppProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileWriter {

    private final PhotoAppProperties photoAppProperties;

    public Long writeFile( MultipartFile multipartFile, String filePath ) {
        try {
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            multipartFile.transferTo(new File(filePath));
        } catch (IllegalStateException ile) {
            throw new RuntimeException("file write error");
        } catch ( IOException ioe) {
            throw new RuntimeException("ioe error");
        }
        return multipartFile.getSize();
    }

    public String getFilePath(String uploadFileName, MultipartFile sourceFile) {
        return photoAppProperties.getDefaultPath() + File.separator + dateStr() + File.separator + uploadFileName + "." + getMimeType(sourceFile.getOriginalFilename());
    }

    private static String getMimeType(String filePath) {
        return FilenameUtils.getExtension(filePath);
    }

    public static String dateStr() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return now.format(dateTimeFormatter);
    }
}
