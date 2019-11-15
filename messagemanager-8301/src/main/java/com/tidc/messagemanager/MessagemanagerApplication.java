package com.tidc.messagemanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.tidc"})//这是表示公共模块api
@MapperScan("com.tidc.messagemanager.mapper")
@ComponentScan(basePackages = {"com.tidc.api","com.tidc.messagemanager"})
public class MessagemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagemanagerApplication.class, args);
	}

}
