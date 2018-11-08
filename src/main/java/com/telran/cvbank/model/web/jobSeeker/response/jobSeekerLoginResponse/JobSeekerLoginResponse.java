package com.telran.cvbank.model.web.jobSeeker.response.jobSeekerLoginResponse;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JobSeekerLoginResponse {
    private JobSeekerLoginProfile jobSeeker;
    private List<CvList> cvList;
}
