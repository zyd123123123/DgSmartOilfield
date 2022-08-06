package com.sydx.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@EnableDiscoveryClient
@SpringBootApplication

public class ScYzAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScYzAuthApplication.class, args);
    }

}
