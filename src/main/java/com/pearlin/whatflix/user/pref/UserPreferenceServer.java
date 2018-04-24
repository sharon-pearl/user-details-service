package com.pearlin.whatflix.user.pref;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class UserPreferenceServer {

	public static void main(String...args) {
		SpringApplication.run(UserPreferenceServer.class, args);
		System.out.println("Starting User Preferences Server");
	}
}