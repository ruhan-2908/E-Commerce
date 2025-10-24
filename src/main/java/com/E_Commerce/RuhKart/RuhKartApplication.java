package com.E_Commerce.RuhKart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RuhKartApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuhKartApplication.class, args);
	}

}
