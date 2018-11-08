package com.telran.cvbank.model.web.jobSeeker.request.CvRequest;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CvProjectJobs {
    private String company;
    private Boolean isCompanyVisible;
    private String position;
    private String backEndFrontEndRatio;
    private Date startDate;
    private Date endDate;
    private String projectDescription;
}
