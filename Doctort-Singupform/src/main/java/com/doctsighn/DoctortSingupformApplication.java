package com.doctsighn;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.doctsighn")
public class DoctortSingupformApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctortSingupformApplication.class, args);
	}

}
