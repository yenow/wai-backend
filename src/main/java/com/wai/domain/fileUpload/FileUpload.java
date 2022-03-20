package com.wai.domain.fileUpload;

import com.wai.domain.common.BaseEntity;
import com.wai.domain.user.User;
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

    @OneToOne(mappedBy = "profileImageFile")
    private User user;

    @Column(columnDefinition = "varchar(50)")
    private String mimeType;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(200)")
    private FileType fileType;
    @Column(columnDefinition = "varchar(200)")
    private String uploadFileName;
    @Column(columnDefinition = "varchar(200)")
    private String originalFileName;
    @Column(columnDefinition = "varchar(200)")
    private String filePath;
    @Column
    private Long fileSize;
}
