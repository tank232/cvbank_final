package com.telran.cvbank.service.jobseekerCv;

import com.telran.cvbank.model.web.jobSeeker.request.CvRequest.CvRequest;
import com.telran.cvbank.model.web.jobSeeker.response.CvResponse;
import com.telran.cvbank.model.web.jobSeeker.response.ShowCvRegistryResponse;

public interface JobseekerCvService {
    ShowCvRegistryResponse ShowCvRegistryResponse(String email);

    CvResponse save(CvRequest cvRequest);
    CvResponse delete(String cvId);
     // ResponseSaveCv saveCv(String token, RequestSaveCV requestSaveCV);
}
