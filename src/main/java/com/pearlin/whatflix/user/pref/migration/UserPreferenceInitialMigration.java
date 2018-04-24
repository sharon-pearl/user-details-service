package com.pearlin.whatflix.user.pref.migration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pearlin.whatflix.user.pref.mongo.UserEntity;

@Component
public class UserPreferenceInitialMigration {

	@Value("${migration.initial.file}")
	String fileName;

	@Autowired
	private MongoTemplate mongoTemplate;

	private static final String PREFERRED_LANGUAGES = "preferred_languages";
	private static final String FAVOURITE_ACTORS = "favourite_actors";
	private static final String FAVOURITE_DIRECTORS = "favourite_directors";

	private static final Logger logger = LoggerFactory.getLogger(UserPreferenceInitialMigration.class);

	public boolean start() {
		try {
			logger.info("start");
			JsonElement data = readJsonFile();
			insertDataInMongo(data);
		} catch (Exception e) {
			logger.error("Error during migration", e);
		}
		return true;
	}

	private JsonElement readJsonFile() throws Exception {
		ClassPathResource jsonFile = new ClassPathResource(fileName);
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(new String(jsonFile.getInputStream().readAllBytes()));
		return data;
	}

	private void insertDataInMongo(JsonElement data) {
		if (data.isJsonArray()) {
			JsonArray array = (JsonArray) data;
			Iterator<JsonElement> it = array.iterator();
			array.forEach((v) -> {
				JsonElement element = v;
				JsonObject obj = element.getAsJsonObject();
				Set<Entry<String, JsonElement>> user = obj.entrySet();
				long userId = Long.parseLong(user.iterator().next().getKey());
				JsonObject userPref = user.iterator().next().getValue().getAsJsonObject();
				UserEntity entity = createUser(userId, getField(userPref, PREFERRED_LANGUAGES),
						getField(userPref, FAVOURITE_ACTORS), getField(userPref, FAVOURITE_DIRECTORS));
				insertToMongo(entity);
			});
		}
	}

	private List<String> getField(JsonObject userPref, String fieldName) {
		List<String> field = new ArrayList<String>();
		if (userPref.get(fieldName).isJsonArray()) {
			JsonArray fieldValue = userPref.get(fieldName).getAsJsonArray();
			fieldValue.forEach((v) -> {
				field.add(v.getAsString());
			});
		} else {
			return null;
		}
		return field;
	}

	private UserEntity createUser(long userId, List<String> preferredLanguages, List<String> favActors,
			List<String> favDirectors) {
		UserEntity user = new UserEntity(userId);
		user.setFavActors(favActors);
		user.setFavDirectors(favDirectors);
		user.setPreferredLanguages(preferredLanguages);
		return user;
	}

	private void insertToMongo(UserEntity user) {
		try {
			mongoTemplate.insert(user);
		} catch (Exception e) {
			logger.error("Error while inserting user to mongo" + user, e);
		}

	}
}
