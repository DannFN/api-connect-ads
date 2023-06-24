package com.org.connect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.org.connect" })
public class ConnectApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConnectApplication.class, args);
	}
}
