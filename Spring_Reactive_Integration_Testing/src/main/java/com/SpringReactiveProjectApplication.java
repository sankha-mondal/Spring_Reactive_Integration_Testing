package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringReactiveProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveProjectApplication.class, args);
		System.out.println("Spring Reactive Project Running on Port No 8585...");
	}
}
