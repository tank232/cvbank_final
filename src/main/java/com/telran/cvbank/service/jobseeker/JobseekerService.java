package com.telran.cvbank.service.jobseeker;

import com.telran.cvbank.model.web.jobSeeker.request.JobSeekerRegistrationRequest;
import com.telran.cvbank.model.web.jobSeeker.response.JobSeekerResponse;
import com.telran.cvbank.model.web.jobSeeker.response.ShowCvRegistryResponse;
import com.telran.cvbank.model.web.jobSeeker.response.getCatalogsResponse.GetCatalogsResponse;

public interface JobseekerService {
    JobSeekerResponse authorization(String authorization,String remoteAddr);
    void unauthorization(String email);
    JobSeekerResponse registration(JobSeekerRegistrationRequest jobSeekerRegistrationRequest, String authorization,String remoteAddr);

    GetCatalogsResponse getCatalogs(String email);

}