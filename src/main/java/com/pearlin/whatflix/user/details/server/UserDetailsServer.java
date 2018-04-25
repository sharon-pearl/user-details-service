package com.pearlin.whatflix.user.details.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = { "com.pearlin.whatflix.user.details.server",
		"com.pearlin.whatflix.user.details.mongo", "com.pearlin.whatflix.user.details.service" })
@EnableMongoRepositories
public class UserDetailsServer {

	public static void main(String... args) {
		SpringApplication.run(UserDetailsServer.class, args);
		System.out.println("Starting User Preferences Server");
	}
}