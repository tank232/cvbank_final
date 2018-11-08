package com.telran.cvbank.repository.jobseeker;

import com.telran.cvbank.model.repositoryModel.DictModel;
import com.telran.cvbank.model.repositoryModel.JobSeekerRepositoryModel;

import java.util.List;

public interface JobseekerRepository {

    void createJobseeker(JobSeekerRepositoryModel jobSeekerRepositoryModel);

    JobSeekerRepositoryModel getJobSeekerRepositoryModel(String login);

    void setValidSession(String email, Boolean valid);

    void setRemoteAddr(String email, String remoteAddr);

    List<DictModel> getDict();
}