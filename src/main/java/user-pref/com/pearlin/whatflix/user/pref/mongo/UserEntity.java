package com.pearlin.whatflix.user.pref.mongo;

import java.util.List;

public class UserEntity {

	private long userId;
	private List<String> preferredLanguages;
	private List<String> favActors;
	private List<String> favDirectors;
	private List<String> searchedActors;
	private List<String> searchedDirectors;

	public UserEntity(long userId) {
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

	public List<String> getSearchedActors() {
		return searchedActors;
	}

	public void setSearchedActors(List<String> searchedActors) {
		this.searchedActors = searchedActors;
	}

	public List<String> getSearchedDirectors() {
		return searchedDirectors;
	}

	public void setSearchedDirectors(List<String> searchedDirectors) {
		this.searchedDirectors = searchedDirectors;
	}

	public long getUserId() {
		return userId;
	}

}