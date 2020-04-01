package com.CRUD_lab.lab0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.CRUD_lab.lab0.Controller")
public class Lab0Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab0Application.class, args);
	}

}
