package com.Bank.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BankDetApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankDetApplication.class, args);

	}
	@Bean
	public RestTemplate restTemplatel() {
		return new RestTemplate();
	}

}
