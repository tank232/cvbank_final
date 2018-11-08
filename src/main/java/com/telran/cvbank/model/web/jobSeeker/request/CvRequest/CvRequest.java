package com.telran.cvbank.model.web.jobSeeker.request.CvRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CvRequest {

    @NotBlank
    private String cvId;
    @NotBlank
    private String cvName;
    @NotBlank
    private CvTitle title;
    private Boolean isTitleVisible;
    @NotBlank
    private CvExperience experience;
    @NotBlank
    private CvContactInfo contactInfo;
    private Boolean isContactInfoVisible;
    @NotBlank
    private CvDescription description;
    private List<CvEducation> education;
    private List<CvSkill> skills;
    private List<CvProjectJobs> projectJobs;
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
