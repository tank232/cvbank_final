package com.telran.cvbank.model.mongoModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telran.cvbank.model.mongoModel.JobSeekerSvSet.EducationRepositoryModel;
import com.telran.cvbank.model.mongoModel.JobSeekerSvSet.ExperienceRepositoryModel;
import com.telran.cvbank.model.mongoModel.JobSeekerSvSet.SkillRepositoryModel;
import com.telran.cvbank.model.mongoModel.JobSeekerSvSet.ProjectJobRepositoryModel;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Document(collection = "cv")
public class JobSeekerCvMongoModel {
    private String emailJobSeeker;
    @JsonProperty("_id")
    private String cvId;
    private String cvName;
    @Transient
    private Integer viewCount;
    private String firstName;
    private Boolean isFirstnameVisible;
    private String lastName;
    private Boolean isLastNameVisible;
    private Boolean isTitleVisible;
    private Double totalExperience;
    private String residence;
    private Boolean isResidenceVisible;
    private Date birthday;
    private String about;
    private Boolean isBirthdayVisible;
    private String phone;
    private Boolean isPhoneVisible;
    private String email;
    private Boolean isEmailVisible;
    private String linkedIn;
    private Boolean isLinkedInVisible;
    private Boolean isContactInfoVisible;
    private String position;
    private Integer salaryFrom;
    private Integer salaryTo;
    private Boolean isFooterLinkVisible;
    private Boolean isActive;
    private String cvStyle;
    private Integer backEndFrontEndRatio;
    private Date auditDate;
    private Date auditCDate;
    private Set<SkillRepositoryModel> skills;
    private Set<String> residences;
    private Set<String> languages;
    private Set<String> footerLinks;
    private Set<ExperienceRepositoryModel> experiences;
    private Set<EducationRepositoryModel> educations;
    private Set<ProjectJobRepositoryModel> projectJobs;
    private Set<String> certifications;
    private Set<String> achivements;
    private Set<String> preferableArea;
    private Set<String> footerInfo;
    private Boolean isFooterInfoVisible;

}
