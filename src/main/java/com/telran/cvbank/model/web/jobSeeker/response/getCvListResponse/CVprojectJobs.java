package com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CVprojectJobs {
    private String company;
    private Boolean isCompanyVisible;
    private String position;
    private String backEndFrontEndRatio;
    private Date startDate;
    private Date endDate;
    private String projectDescription;
}
