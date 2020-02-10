package com.example.outside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.outside.service")
@EnableDiscoveryClient
public class OutsideProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutsideProjectApplication.class, args);
	}

}
