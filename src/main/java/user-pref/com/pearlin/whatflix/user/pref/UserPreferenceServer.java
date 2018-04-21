package com.pearlin.whatflix.user.pref;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserPreferenceServer {

	public static void main(String...args) {
		SpringApplication.run(UserPreferenceServer.class, args);
		System.out.println("Starting User Preferences Server");
	}
}