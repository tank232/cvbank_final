package com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CVcontactInfo {
    private String residence;
    private Boolean isResidenceVisible;
    private Date birthday;
    private Boolean isBirthdayVisible;
    private String phone;
    private Boolean isPhoneVisible;
    private String email;
    private Boolean isEmailVisible;
    private String linkedIn;
    private Boolean isLinkedInVisible;
}
