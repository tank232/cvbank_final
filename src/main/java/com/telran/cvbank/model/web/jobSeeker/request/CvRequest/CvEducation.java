package com.telran.cvbank.model.web.jobSeeker.request.CvRequest;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CvEducation {
    private String schoolInstitutionName;
    private String degree;
    private String graduationYear;
    private String location;
    private String details;
    private Boolean isEducationVisible;
}
