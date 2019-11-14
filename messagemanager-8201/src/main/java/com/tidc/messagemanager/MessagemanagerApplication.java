package com.tidc.messagemanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.tidc.messagemanager.mapper")
public class MessagemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagemanagerApplication.class, args);
	}

}
