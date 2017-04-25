package com.hucet.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockSchedulerApplication.class, args);
	}
}
