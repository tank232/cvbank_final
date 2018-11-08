package com.telran.cvbank.model.web.jobSeeker.request.CvRequest;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CvSkill {
    private String skillName;
    private Boolean isProved;
}
