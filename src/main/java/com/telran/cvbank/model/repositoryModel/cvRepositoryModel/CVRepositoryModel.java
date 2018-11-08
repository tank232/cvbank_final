package com.telran.cvbank.model.repositoryModel.cvRepositoryModel;


import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CVRepositoryModel {
    private String cvId;
    private String cvName;
    private Integer viewCount;
    private String firstname;
    private Boolean isFirstnameVisible;
    private String lastName;
    private Boolean isLastNameVisible;
    private Boolean isTitleVisible;
    private Double totalExperience;
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
    private Boolean isContactInfoVisible;
    private String about;
    private String position;
    private Integer salaryFrom;
    private Integer salaryTo;
    private Boolean isFooterLinkVisible;
    private Boolean isFooterInfoVisible;
    private Boolean isActive;
    private String cvStyle;
    private List<String> preferableArea;
    private List<String> achivements;
    private List<String> certifications;
    private List<String> languages;
    private List<String> footerLinks;
    private List<String> footerInfo;
    private List<CVlocalExperienceRepositoryModel> localExperience;
    private List<CVeducationRepositoryModel> education;
    private List<CVskillsRepositoryModel> skills;
    private List<CVprojectJobsRepositoryModel> projectJobs;
}
