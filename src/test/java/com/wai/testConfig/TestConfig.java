package com.wai.testConfig;

import com.wai.common.util.Utility;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    public Utility utility() {
        return new Utility();
    }
}