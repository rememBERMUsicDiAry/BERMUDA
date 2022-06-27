package com.example.bermuda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BermudaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BermudaApplication.class, args);
	}

}
