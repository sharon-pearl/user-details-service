package com.pearlin.whatflix.user.details.mongo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user_preferences")
public class UserPreferencesEntity {

	// TODO Implement Builder Pattern

	@Id
	private long userId;

	@Field("preferred_languages")
	private List<String> preferredLanguages;

	@Field("favourite_actors")
	private List<String> favActors;

	@Field("favourite_directors")
	private List<String> favDirectors;

	@Field("searched")
	private List<String> searched;

	public UserPreferencesEntity(long userId) {
		this.userId = userId;
	}

	public List<String> getPreferredLanguages() {
		return preferredLanguages;
	}

	public void setPreferredLanguages(List<String> preferredLanguages) {
		this.preferredLanguages = preferredLanguages;
	}

	public List<String> getFavActors() {
		return favActors;
	}

	public void setFavActors(List<String> favActors) {
		this.favActors = favActors;
	}

	public List<String> getFavDirectors() {
		return favDirectors;
	}

	public void setFavDirectors(List<String> favDirectors) {
		this.favDirectors = favDirectors;
	}

	public List<String> getSearched() {
		return searched;
	}

	public void setSearched(List<String> searched) {
		this.searched = searched;
	}

	public long getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "UserPreferencesEntity [userId=" + userId + ", preferredLanguages=" + preferredLanguages + ", favActors="
				+ favActors + ", favDirectors=" + favDirectors + ", searched=" + searched + "]";
	}

}