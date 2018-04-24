package com.pearlin.whatflix.user.pref.mongo;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.name}")
	String dbName;

	@Value("${spring.data.mongodb.host}")
	String host;

	@Value("${spring.data.mongodb.port}")
	int port;

	@Value("${spring.data.mongodb.username}")
	String userName;

	@Value("${spring.data.mongodb.password}")
	String password;

	private static final Logger logger = LoggerFactory.getLogger(MongoConfig.class);

	@Override
	public MongoClient mongoClient() {
		List<ServerAddress> address = Collections.singletonList(new ServerAddress(host, port));
		MongoCredential cred = MongoCredential.createCredential(userName, dbName, password.toCharArray());
		MongoClientOptions options = MongoClientOptions.builder().build();
		MongoClient client = new MongoClient(address, cred, options);
		return client;
	}

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	// TODO Remove _class field
	// public @Bean MongoTemplate mongoTemplate() throws Exception {
	//
	// // remove _class
	// MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory(),
	// new MongoMappingContext());
	// converter.setTypeMapper(new DefaultMongoTypeMapper(null));
	//
	// MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
	//
	// return mongoTemplate;
	//
	// }

}
