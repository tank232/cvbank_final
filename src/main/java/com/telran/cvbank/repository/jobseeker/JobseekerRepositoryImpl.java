package com.telran.cvbank.repository.jobseeker;

import com.telran.cvbank.model.mongoModel.DictMongoModel;
import com.telran.cvbank.model.mongoModel.UserSessionMongoModel;
import com.telran.cvbank.model.repositoryModel.DictModel;
import com.telran.cvbank.model.repositoryModel.JobSeekerRepositoryModel;
import com.telran.cvbank.model.mongoModel.JobSeekerMongoModel;
import com.telran.cvbank.repository.mongoRepository.DictMongoRepository;
import com.telran.cvbank.repository.mongoRepository.JobSeekerMongoRepositry;
import com.telran.cvbank.repository.mongoRepository.UserSessionMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JobseekerRepositoryImpl implements JobseekerRepository {

    @Autowired
    private JobSeekerMongoRepositry jobSeekerMongoRepositry;
    @Autowired
    private UserSessionMongoRepository userSessionMongoRepository;
    @Autowired
    private DictMongoRepository dictMongoRepository;

    @Override
    public JobSeekerRepositoryModel getJobSeekerRepositoryModel(String email)
    {
        JobSeekerMongoModel jobSeeker= jobSeekerMongoRepositry.findJobSeekerMongoModelByEmail(email);
        UserSessionMongoModel userSessionMongoModel =userSessionMongoRepository.findUserSessionMongoModelByEmail(email);
        return JobSeekerRepositoryModel.builder()
                .email(jobSeeker.getEmail())
                .remoteAddr(userSessionMongoModel.getRemoteAddr())
                .token(userSessionMongoModel.getToken())
                .password(userSessionMongoModel.getPassword()).phone(jobSeeker.getPhone()).firstName(jobSeeker.getFirstName())
                .lastName(jobSeeker.getLastName()).build();
    }

    @Override
    public void setValidSession(String email, Boolean valid) {
        UserSessionMongoModel userSessionMongoModel =userSessionMongoRepository.findUserSessionMongoModelByEmail(email);
        userSessionMongoModel.setValid(valid);
    }

    @Override
    public void setRemoteAddr(String email, String remoteAddr) {
        UserSessionMongoModel userSessionMongoModel =userSessionMongoRepository.findUserSessionMongoModelByEmail(email);
        userSessionMongoModel.setRemoteAddr(remoteAddr);
    }

    @Override
    public List<DictModel> getDict() {
        List<DictMongoModel> dictMongoModel=dictMongoRepository.findAll();
        return dictMongoModel.stream().map(x->new DictModel(x.getNameDictionary(),x.getListValues())).collect(Collectors.toList());
    }


    @Override
    public void createJobseeker(JobSeekerRepositoryModel jobSeekerRepositoryModel) {
       JobSeekerMongoModel jobSeeker=
                JobSeekerMongoModel.builder().firstName(jobSeekerRepositoryModel.getFirstName())
                        .lastName(jobSeekerRepositoryModel.getLastName()).email(jobSeekerRepositoryModel.getEmail())
                        .phone(jobSeekerRepositoryModel.getPhone()).password(jobSeekerRepositoryModel.getPassword()).build();
        jobSeeker.setEmail(jobSeekerRepositoryModel.getEmail());
        jobSeeker.setPhone(jobSeekerRepositoryModel.getPhone());
        jobSeekerMongoRepositry.insert(jobSeeker);

        userSessionMongoRepository.insert(UserSessionMongoModel.builder().email(jobSeekerRepositoryModel.getEmail())
                .password(jobSeekerRepositoryModel.getPassword()).token(jobSeekerRepositoryModel.getToken())
                .valid(true).roles(Arrays.asList("jobSeeker")).remoteAddr(jobSeekerRepositoryModel.getRemoteAddr()).build());
    }


}