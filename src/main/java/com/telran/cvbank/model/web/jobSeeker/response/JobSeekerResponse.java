package com.telran.cvbank.model.web.jobSeeker.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JobSeekerResponse {
    private String token;
    private JobSeekerInnerResponse jobSeekerInnerResponse;
}
