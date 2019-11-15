package com.tidc.usermanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.tidc"})//这是表示公共模块api
@MapperScan("com.tidc.usermanager.mapper")
@ComponentScan(basePackages = {"com.tidc.api"})
public class UsermanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermanagerApplication.class, args);
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
