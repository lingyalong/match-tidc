package com.tidc.contest8401;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.tidc"})//这是表示公共模块api
@MapperScan("com.tidc.contest8401.mapper")
@ComponentScan(basePackages = {"com.tidc.api","com.tidc.contest8401"})
@EnableScheduling
public class Contest8401Application {

	public static void main(String[] args) {
		SpringApplication.run(Contest8401Application.class, args);
	}

}
