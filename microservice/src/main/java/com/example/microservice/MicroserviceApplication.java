package com.example.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MicroserviceApplication {

	public MicroserviceApplication() throws IOException {
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(MicroserviceApplication.class, args);

	}

}
