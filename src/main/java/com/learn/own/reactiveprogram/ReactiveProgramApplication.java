package com.learn.own.reactiveprogram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.learn.own")
@SpringBootApplication
public class ReactiveProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgramApplication.class, args);
	}

}
