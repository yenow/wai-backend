package com.wai.config;

import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@Data
public class PhotoAppProperties {
    @Value("${spring.servlet.multipart.location}")
    private String defaultPath;

    @PostConstruct
    private void init() {
        log.info("path:: {}",this.defaultPath);
    }
}
