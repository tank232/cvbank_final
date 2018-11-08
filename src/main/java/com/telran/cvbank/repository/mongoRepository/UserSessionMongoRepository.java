package com.telran.cvbank.repository.mongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.telran.cvbank.model.mongoModel.UserSessionMongoModel;

public interface UserSessionMongoRepository extends MongoRepository<UserSessionMongoModel,String> {
    UserSessionMongoModel findUserSessionMongoModelByToken(String token);

    UserSessionMongoModel findUserSessionMongoModelByEmail(String email);
}
