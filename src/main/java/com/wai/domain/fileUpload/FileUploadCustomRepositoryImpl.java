package com.wai.domain.fileUpload;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wai.dto.fileUpload.FileUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.wai.domain.fileUpload.QFileUpload.fileUpload;

@RequiredArgsConstructor
@Repository
public class FileUploadCustomRepositoryImpl implements FileUploadCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<FileUpload> findByFileType() {
        return jpaQueryFactory
                .selectFrom(fileUpload)
                .where(fileUpload.fileType.eq(FileType.theme))
                .fetch();
    }
}
