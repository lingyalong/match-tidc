package com.tidc.consumer8001;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableCircuitBreaker
@EnableDiscoveryClient //发现服务
@EnableFeignClients(basePackages = {"com.tidc"})//这是表示公共模块api
@MapperScan("com.tidc.consumer8001.mapper")
@ComponentScan(basePackages = {"com.tidc.api","com.tidc.consumer8001"})
public class Consumer8001Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer8001Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
