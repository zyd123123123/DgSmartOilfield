package com.cyrj.jxzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author admin
 */
@SpringBootApplication
@MapperScan("com.cyrj.jxzy.dao.**.*")
@ComponentScan(basePackages = { "com.cyrj.jxzy" })
@EntityScan("com.cyrj.jxzy.entity")
@EnableDiscoveryClient
public class Yw2Application {

	public static void main(String[] args) {
		SpringApplication.run(Yw2Application.class, args);
	}

}
