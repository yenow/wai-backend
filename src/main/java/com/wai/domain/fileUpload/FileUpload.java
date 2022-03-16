package com.wai.domain.fileUpload;

import com.wai.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
public class FileUpload extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long FileId;

    @Column(columnDefinition = "varchar(50)")
    private String mimeType;
    @Column(columnDefinition = "varchar(200)")
    private String fileType;
    @Column(columnDefinition = "varchar(200)")
    private String uploadFileName;
    @Column(columnDefinition = "varchar(200)")
    private String originalFileName;
    @Column(columnDefinition = "varchar(200)")
    private String filePath;
    @Column
    private Long fileSize;
}
