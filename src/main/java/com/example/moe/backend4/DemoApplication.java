package com.example.moe.backend4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.moe.backend4.rest","com.example.moe.backend4.entity", "com.example.moe.backend4.dao",  "com.example.moe.backend4.service" })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
