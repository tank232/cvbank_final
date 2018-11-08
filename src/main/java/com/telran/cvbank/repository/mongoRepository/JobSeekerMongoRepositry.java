package com.telran.cvbank.repository.mongoRepository;

import com.telran.cvbank.model.mongoModel.JobSeekerMongoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobSeekerMongoRepositry extends MongoRepository<JobSeekerMongoModel, String> {


    JobSeekerMongoModel findJobSeekerMongoModelByEmail(String email);
}
