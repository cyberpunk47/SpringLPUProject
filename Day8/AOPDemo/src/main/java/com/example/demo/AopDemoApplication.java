package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
@SpringBootApplication
public class AopDemoApplication implements CommandLineRunner{

	@Autowired
	private MyService myService;
	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		myService.displayMessage();
	}

}
