package com.wai.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FileUploadUtility {
    final static String[] imageExtension = {
        "bmp","rle","dib",
        "jpg","jpeg",
        "gif",
        "pgn",
        "tiff","tif",
        "raw"
    };
}
