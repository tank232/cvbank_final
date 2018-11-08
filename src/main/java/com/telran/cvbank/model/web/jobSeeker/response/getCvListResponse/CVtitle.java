package com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CVtitle {
    private String firstname;
    private Boolean isFirstnameVisible;
    private String lastName;
    private Boolean isLastNameVisible;
}
