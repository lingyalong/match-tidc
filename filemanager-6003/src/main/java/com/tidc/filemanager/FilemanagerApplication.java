package com.tidc.filemanager;

import com.tidc.filemanager.properties.MatchProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(MatchProperties.class)
@EnableFeignClients(basePackages = {"com.tidc"})//这是表示公共模块api
@ComponentScan(basePackages = {"com.tidc.api","com.tidc.filemanager"})
public class FilemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilemanagerApplication.class, args);
	}

}
