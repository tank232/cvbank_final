package com.telran.cvbank.model.mongoModel.JobSeekerSvSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectJobRepositoryModel {
        private String company;
        private boolean isCompanyVisible;
        private String position;
        private String backEndFrontEndRatio;
        private Date startDate;
        private Date endDate;
        private String projectDescription;
}
