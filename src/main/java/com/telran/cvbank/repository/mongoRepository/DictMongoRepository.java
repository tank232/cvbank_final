package com.telran.cvbank.repository.mongoRepository;

import com.telran.cvbank.model.mongoModel.DictMongoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Set;

public interface DictMongoRepository extends MongoRepository<DictMongoModel,String> {
   // Set<String> findDictMongoModelByValueOrderByNameDictionary(String nameDictionary);
}
