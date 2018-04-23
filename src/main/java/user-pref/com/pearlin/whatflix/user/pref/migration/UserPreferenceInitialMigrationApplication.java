package com.pearlin.whatflix.user.pref.migration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = "com.pearlin.whatflix.user.pref.migration")
public class UserPreferenceInitialMigrationApplication {

	public static void main(String... args) {
		SpringApplication app = new SpringApplicationBuilder(UserPreferenceInitialMigrationApplication.class).build();
		Map<String, Object> defaultProperties = new HashMap<String, Object>();
		defaultProperties.put("spring.config.name", "migration");
		app.setDefaultProperties(defaultProperties);
		app.run(args);
	}
}