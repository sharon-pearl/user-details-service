package com.pearlin.whatflix.user.details.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pearlin.whatflix.user.details.mongo.entity.UserPreferencesEntity;
import com.pearlin.whatflix.user.details.service.UserPreferencesService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserPreferencesService userPreferenceService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/getUserPreferences/{userId}", produces = "application/json")
	public UserPreferencesEntity getUserPreference(@PathVariable("userId") long userId) {
		UserPreferencesEntity entity = userPreferenceService.getUserPreferencesEntity(userId);
		logger.info(entity.toString());
		return entity;
	}
}