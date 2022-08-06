package com.sydx.zc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ScZcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScZcApplication.class, args);
    }
//
//    @EnableWebSecurity
//    static class  ssdf extends WebSecurityConfigurerAdapter {
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//
//            super.configure(http);
//
//            http.csrf().disable();
//        }
//    }
}
