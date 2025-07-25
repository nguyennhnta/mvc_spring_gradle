package com.dev.mvc_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MvcSpringGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcSpringGradleApplication.class, args);
	}

}
