package com.project.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.out;

@SpringBootApplication
public class TaskAppApplication {

	public static void main(String[] args) {
		out.println("Hi Project");
		SpringApplication.run(TaskAppApplication.class, args);
//        out.println("hi");
	}

}
