package com.pearlin.whatflix.user.details.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = { "com.pearlin.whatflix.user.details.server",
		"com.pearlin.whatflix.user.details.mongo", "com.pearlin.whatflix.user.details.service" })
@EnableMongoRepositories
public class UserDetailsServer {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServer.class);

	public static void main(String... args) {
		SpringApplication.run(UserDetailsServer.class, args);
		logger.info("Starting User Details Server");
	}
}