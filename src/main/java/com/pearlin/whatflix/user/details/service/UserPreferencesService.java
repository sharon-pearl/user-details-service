package com.pearlin.whatflix.user.details.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pearlin.whatflix.user.details.mongo.entity.UserPreferencesEntity;
import com.pearlin.whatflix.user.details.mongo.repository.UserPreferencesRepository;

@Service
public class UserPreferencesService {

	@Autowired
	private UserPreferencesRepository userPreferencesRepository;

	private static final Logger logger = LoggerFactory.getLogger(UserPreferencesService.class);

	public UserPreferencesEntity getUserPreferencesEntity(long userId) {
		UserPreferencesEntity entity = null;
		try {
			//TODO Project only required
			entity = userPreferencesRepository.findById(userId).get();
		} catch (Exception e) {
			logger.error("Error while finding user preference data for" + userId, e);
		}
		return entity;
	}

}
