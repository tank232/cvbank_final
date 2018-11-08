package com.telran.cvbank.model.web.jobSeeker.request.CvRequest;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CvTitle {
    private String firstname;
    private Boolean isFirstnameVisible;
    private String lastName;
    private Boolean isLastNameVisible;
}
