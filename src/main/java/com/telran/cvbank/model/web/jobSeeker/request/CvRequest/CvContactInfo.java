package com.telran.cvbank.model.web.jobSeeker.request.CvRequest;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CvContactInfo {
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
