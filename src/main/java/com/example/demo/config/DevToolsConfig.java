package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

//@Configuration
//public class DevToolsConfig implements RestartEventListener {
//
//    private static final Logger logger = LoggerFactory.getLogger(DevToolsConfig.class);
//
//    @Override
//    public void onApplicationEvent(RestartEvent event) {
//        logger.info("Application restarted at: {}", LocalDateTime.now());
//    }
//
//    @Bean
//    public RestartEventListener restartEventListener() {
//        return new DevToolsConfig();
//    }
//
//}