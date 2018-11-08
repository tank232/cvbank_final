package com.telran.cvbank.model.mongoModel.JobSeekerSvSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EducationRepositoryModel {
    private String  schoolInstitutionName;
    private String degree;
    private String graduationYear;
    private String location;
    private String details;
    private Boolean isEducationVisible;
}
