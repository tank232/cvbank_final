package com.telran.cvbank.model.repositoryModel.cvRepositoryModel;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CVprojectJobsRepositoryModel {
    private String company;
    private Boolean isCompanyVisible;
    private String position;
    private String backEndFrontEndRatio;
    private Date startDate;
    private Date endDate;
    private String projectDescription;
}
