package com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CVskills {
    private String skillName;
    private Boolean isProved;
}
