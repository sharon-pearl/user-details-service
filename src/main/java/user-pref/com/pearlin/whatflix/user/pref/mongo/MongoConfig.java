package com.pearlin.whatflix.user.pref.mongo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


@Configuration
public class MongoConfig {// extends AbstractMongoConfiguration{

	@Value("${database.mongo.userpref.host}")
	String host;

	@Value("${database.mongo.userpref.port}")
	String port;

	@Value("${database.mongo.userpref.username}")
	String username;

	@Value("${database.mongo.userpref.password}")
	String password;

	@PostConstruct
	public void init() {
		String connectionString = "mongodb://" + username + ":" + password + "@" + host + ":" + port
				+ "/?authSource=db1&ssl=true";
		MongoClient mongoClient = MongoClients.create();
	}

}
