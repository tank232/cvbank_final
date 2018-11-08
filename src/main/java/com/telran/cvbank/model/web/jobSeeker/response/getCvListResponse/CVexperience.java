package com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CVexperience {
    private List<CVlocalExperience> localExperience;
    private Double totalExperience;
}
