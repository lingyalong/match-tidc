package com.tidc.zuul9537;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul9537Application {

	public static void main(String[] args) {
		SpringApplication.run(Zuul9537Application.class, args);
	}

}
