package com.pearlin.whatflix.user.pref.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCollection extends MongoRepository<UserEntity, Long>{

}