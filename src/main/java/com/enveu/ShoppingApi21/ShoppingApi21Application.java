package com.enveu.ShoppingApi21;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingApi21Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApi21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Hello World");
	}
}
