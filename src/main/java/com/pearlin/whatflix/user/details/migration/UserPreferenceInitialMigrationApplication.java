package com.pearlin.whatflix.user.details.migration;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = { "com.pearlin.whatflix.user.details.migration",
		"com.pearlin.whatflix.user.details.mongo" })
public class UserPreferenceInitialMigrationApplication {

	private static final Logger logger = LoggerFactory.getLogger(UserPreferenceInitialMigration.class);

	// TODO turn off listening to a port
	public static void main(String... args) {
		long start = System.currentTimeMillis();
		SpringApplication app = new SpringApplicationBuilder(UserPreferenceInitialMigrationApplication.class).build();
		Map<String, Object> defaultProperties = new HashMap<String, Object>();
		defaultProperties.put("spring.config.name", "migration");
		app.setDefaultProperties(defaultProperties);
		ApplicationContext context = app.run(args);
		UserPreferenceInitialMigration migration = context.getBean(UserPreferenceInitialMigration.class);
		if (migration.start()) {
			logger.info("User Preference Migration successful");
		} else {
			logger.info("User Preference Migration Unsuccessful");
		}
		long end = System.currentTimeMillis();
		logger.info("Time taken in seconds : " + (end - start) / 1000);
	}
}