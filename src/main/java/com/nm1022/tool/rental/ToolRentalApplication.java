package com.nm1022.tool.rental;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToolRentalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ToolRentalApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Hello World");
	}
}