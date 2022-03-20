package com.wai.domain.fileUpload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum FileType {
    imageTheme, image,
}
