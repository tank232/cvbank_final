package com.telran.cvbank.model.repositoryModel.cvRepositoryModel;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CVeducationRepositoryModel {
    private String schoolInstitutionName;
    private String degree;
    private String graduationYear;
    private String location;
    private String details;
    private Boolean isEducationVisible;
}
