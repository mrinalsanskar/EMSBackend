package com.cg.ems;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EmsEmployeeSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsEmployeeSearchApplication.class, args);
	}
}