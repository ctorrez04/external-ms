package com.example.outside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OutsideProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutsideProjectApplication.class, args);
	}

}
