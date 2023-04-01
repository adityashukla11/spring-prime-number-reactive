package com.app.reactivejavapractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.SubmissionPublisher;

@SpringBootApplication
public class ReactiveJavaPracticeApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ReactiveJavaPracticeApplication.class, args);
	}

}
