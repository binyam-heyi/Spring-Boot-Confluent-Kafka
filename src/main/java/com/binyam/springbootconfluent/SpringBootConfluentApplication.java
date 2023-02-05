package com.binyam.springbootconfluent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
//@EnableKafkaStreams
public class SpringBootConfluentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfluentApplication.class, args);
	}

}

