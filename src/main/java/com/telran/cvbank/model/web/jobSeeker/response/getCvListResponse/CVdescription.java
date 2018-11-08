package com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CVdescription {
    private String about;
    private List<String> preferableArea;
    private String position;
    private Integer salaryFrom;
    private Integer salaryTo;
}
