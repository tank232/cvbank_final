package com.telran.cvbank.model.web.jobSeeker.response.jobSeekerLoginResponse;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CvList {
    private String cvId;
    private String cvName;
    private Integer viewCount;
}
