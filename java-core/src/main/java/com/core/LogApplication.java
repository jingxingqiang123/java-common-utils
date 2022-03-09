package com.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
        log.info("LogApplication start successful.");
    }
}
