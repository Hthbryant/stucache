package com.qf.stu_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class StuConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuConfigApplication.class, args);
    }

}
