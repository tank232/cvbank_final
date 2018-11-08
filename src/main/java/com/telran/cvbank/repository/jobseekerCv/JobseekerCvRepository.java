package com.telran.cvbank.repository.jobseekerCv;

import com.telran.cvbank.model.repositoryModel.cvRepositoryModel.*;

import java.util.List;
import java.util.Set;

public interface JobseekerCvRepository {
    public List<CVAllRepositoryModel> getCVAllbyEmail(String email);
    public void save(CVRepositoryModel cvRepositoryModel);

    void delete(CVRepositoryModel cVRepositoryModel);

    CVRepositoryModel getCVById(String cvId);
}
