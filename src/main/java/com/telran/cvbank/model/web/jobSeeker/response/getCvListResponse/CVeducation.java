package com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CVeducation {
    private String schoolInstitutionName;
    private String degree;
    private String graduationYear;
    private String location;
    private String details;
    private Boolean isEducationVisible;
}
