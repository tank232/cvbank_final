package com.telran.cvbank.model.web.jobSeeker.request.CvRequest;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CvExperience {
    private List<CvLocExper> localExperience;
    private Double totalExperience;
}
