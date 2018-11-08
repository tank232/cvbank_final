package com.telran.cvbank.model.web.jobSeeker.response;

import com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse.CV;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JobSeekerInnerResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;



}