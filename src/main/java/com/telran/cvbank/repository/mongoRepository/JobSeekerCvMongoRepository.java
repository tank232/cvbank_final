package com.telran.cvbank.repository.mongoRepository;

import com.telran.cvbank.model.mongoModel.JobSeekerCvMongoModel;
import com.telran.cvbank.model.mongoModel.JobSeekerMongoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.awt.print.Pageable;
import java.util.Set;

public interface JobSeekerCvMongoRepository extends MongoRepository<JobSeekerCvMongoModel,String>
{

    Page<JobSeekerCvMongoModel> findAll(Query query, Pageable pageable);

}
