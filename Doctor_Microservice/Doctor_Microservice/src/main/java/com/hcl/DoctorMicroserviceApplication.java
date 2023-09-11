package com.hcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DoctorMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorMicroserviceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		System.out.println("inside doctor main class");
		return new RestTemplate();
	}
}
