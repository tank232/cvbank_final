package com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CV {
    private String cvId;
    private String cvName;
    private Integer viewCount;
    private CVtitle title;
    private Boolean isTitleVisible;
    private CVexperience experience;
    private CVcontactInfo contactInfo;
    private Boolean isContactInfoVisible;
    private CVdescription description;
    private List<CVeducation> education;
    private List<CVskills> skills;
    private List<CVprojectJobs> projectJobs;
    private List<String> achivements;
    private List<String> certifications;
    private List<String> languages;
    private List<String> footerLinks;
    private Boolean isFooterLinkVisible;
    private List<String> footerInfo;
    private Boolean isFooterInfoVisible;
    private Boolean isActive;
    private String cvStyle;
}
