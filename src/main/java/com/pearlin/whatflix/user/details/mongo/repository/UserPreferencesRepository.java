package com.pearlin.whatflix.user.details.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pearlin.whatflix.user.details.mongo.entity.UserPreferencesEntity;

public interface UserPreferencesRepository extends MongoRepository<UserPreferencesEntity, Long> {

}