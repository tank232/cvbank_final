package com.telran.cvbank.service.jobseekerCv;


import com.telran.cvbank.model.repositoryModel.cvRepositoryModel.*;
import com.telran.cvbank.model.web.jobSeeker.request.CvRequest.CvAllRequest;
import com.telran.cvbank.model.web.jobSeeker.request.CvRequest.CvRequest;
import com.telran.cvbank.model.web.jobSeeker.response.CvResponse;
import com.telran.cvbank.model.web.jobSeeker.response.ShowCvRegistryResponse;
import com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse.*;
import com.telran.cvbank.repository.jobseekerCv.JobseekerCvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class JobseekerCvServiceImpl implements JobseekerCvService {

    @Autowired
    private JobseekerCvRepository jobseekerCvRepository;

    @Override
    public ShowCvRegistryResponse ShowCvRegistryResponse(String email) {

        return new ShowCvRegistryResponse(jobseekerCvRepository.getCVAllbyEmail(email).stream()
                .map(x->new CvAllRequest(x.getCvId(),x.getCvName()
                        ,x.getViewCount())).collect(Collectors.toList()));
    }

    @Override
    public CvResponse save(CvRequest cvRequest) {
        CVRepositoryModel cVRepositoryModel =CVRepositoryModel.builder()
        .cvId(cvRequest.getCvId())
        .cvName(cvRequest.getCvName())
        .viewCount(0)
        .firstname(cvRequest.getTitle().getFirstname())
        .isFirstnameVisible(cvRequest.getTitle().getIsFirstnameVisible())
        .lastName(cvRequest.getTitle().getLastName())
        .isLastNameVisible(cvRequest.getTitle().getIsLastNameVisible())
        .isTitleVisible(cvRequest.getIsTitleVisible())
        .localExperience(cvRequest.getExperience().getLocalExperience().stream()
                .map(x->new CVlocalExperienceRepositoryModel(x.getPosition(),x.getYears())).collect(Collectors.toList()))
        .totalExperience(cvRequest.getExperience().getTotalExperience())
        .residence(cvRequest.getContactInfo().getResidence())
        .isResidenceVisible(cvRequest.getContactInfo().getIsResidenceVisible())
        .birthday(cvRequest.getContactInfo().getBirthday())
        .isBirthdayVisible(cvRequest.getContactInfo().getIsBirthdayVisible())
        .phone(cvRequest.getContactInfo().getPhone())
        .isPhoneVisible(cvRequest.getContactInfo().getIsPhoneVisible())
        .email(cvRequest.getContactInfo().getEmail())
        .isEmailVisible(cvRequest.getContactInfo().getIsEmailVisible())
        .linkedIn(cvRequest.getContactInfo().getLinkedIn())
        .isLinkedInVisible(cvRequest.getContactInfo().getIsLinkedInVisible())
        .isContactInfoVisible(cvRequest.getIsContactInfoVisible())
        .about(cvRequest.getDescription().getAbout())
        .preferableArea(cvRequest.getDescription().getPreferableArea())
        .position(cvRequest.getDescription().getPosition())
        .salaryFrom(cvRequest.getDescription().getSalaryFrom())
        .salaryTo(cvRequest.getDescription().getSalaryTo())
        .education(cvRequest.getEducation().stream().map(x->new CVeducationRepositoryModel(
                x.getSchoolInstitutionName(),
                x.getDegree()
                ,x.getGraduationYear()
                ,x.getLocation()
                ,x.getDetails()
                ,x.getIsEducationVisible())).collect(Collectors.toList()))
        .skills(cvRequest.getSkills().stream()
                .map(x->new CVskillsRepositoryModel(x.getSkillName(),x.getIsProved())).collect(Collectors.toList()))
        .projectJobs(cvRequest.getProjectJobs().stream().map(x->new CVprojectJobsRepositoryModel(x.getCompany()
                ,x.getIsCompanyVisible()
                ,x.getPosition()
                ,x.getBackEndFrontEndRatio()
                ,x.getStartDate()
                ,x.getEndDate()
                ,x.getProjectDescription())).collect(Collectors.toList()))
        .achivements(cvRequest.getAchivements())
        .certifications(cvRequest.getCertifications())
        .languages(cvRequest.getLanguages())
        .footerLinks(cvRequest.getFooterLinks())
        .isFooterLinkVisible(cvRequest.getIsFooterLinkVisible())
        .footerInfo(cvRequest.getFooterInfo())
        .isFooterInfoVisible(cvRequest.getIsFooterInfoVisible())
        .isActive(cvRequest.getIsActive())
        . cvStyle(cvRequest.getCvStyle())
       .build();
        return getCvResponse(cVRepositoryModel);
    }

    @Override
    public CvResponse delete(String cvId) {
        CVRepositoryModel cVRepositoryModel=jobseekerCvRepository.getCVById(cvId);
        if(cVRepositoryModel!=null)
        {jobseekerCvRepository.delete(cVRepositoryModel);}
        return getCvResponse(cVRepositoryModel);
    }

    private CvResponse getCvResponse( CVRepositoryModel cVRepositoryModel)
    {return CvResponse.builder().cv(
            new CV(cVRepositoryModel.getCvId(),
                    cVRepositoryModel.getCvName(),
                    cVRepositoryModel.getViewCount(),
                    new CVtitle(
                            cVRepositoryModel.getFirstname(),
                            cVRepositoryModel.getIsFirstnameVisible(),
                            cVRepositoryModel.getLastName(),
                            cVRepositoryModel.getIsLastNameVisible()
                    ),
                    cVRepositoryModel.getIsTitleVisible(),
                    new CVexperience(cVRepositoryModel.getLocalExperience().stream().map(x-> new CVlocalExperience(x.getPosition(),x.getYears())).collect(Collectors.toList()),
                            cVRepositoryModel.getTotalExperience()),
                    new CVcontactInfo (cVRepositoryModel.getResidence(),
                            cVRepositoryModel.getIsResidenceVisible(),
                            cVRepositoryModel.getBirthday(),
                            cVRepositoryModel.getIsBirthdayVisible(),
                            cVRepositoryModel.getPhone(),
                            cVRepositoryModel.getIsPhoneVisible(),
                            cVRepositoryModel.getEmail(),
                            cVRepositoryModel.getIsEmailVisible(),
                            cVRepositoryModel.getLinkedIn(),
                            cVRepositoryModel.getIsLinkedInVisible()),
                    cVRepositoryModel.getIsContactInfoVisible(),
                    new CVdescription(cVRepositoryModel.getAbout(),cVRepositoryModel.getPreferableArea()
                            ,cVRepositoryModel.getPosition(),cVRepositoryModel.getSalaryFrom(),cVRepositoryModel.getSalaryTo()),
                    cVRepositoryModel.getEducation().stream().map(x->new CVeducation(x.getSchoolInstitutionName(),x.getDegree(),x.getGraduationYear(),x.getLocation(),x.getDetails(),x.getIsEducationVisible())).collect(Collectors.toList()),
                    cVRepositoryModel.getSkills().stream().map(x->new CVskills(x.getSkillName(),x.getIsProved())).collect(Collectors.toList()),
                    cVRepositoryModel.getProjectJobs().stream().map(x->new CVprojectJobs(x.getCompany(),
                            x.getIsCompanyVisible(),x.getPosition(),x.getBackEndFrontEndRatio(),x.getStartDate(),x.getEndDate(),x.getProjectDescription())).collect(Collectors.toList()),
                    cVRepositoryModel.getAchivements(),
                    cVRepositoryModel.getCertifications(),
                    cVRepositoryModel.getLanguages(),
                    cVRepositoryModel.getFooterLinks(),
                    cVRepositoryModel.getIsFooterLinkVisible(),
                    cVRepositoryModel.getFooterInfo(),
                    cVRepositoryModel.getIsFooterInfoVisible(),
                    cVRepositoryModel.getIsActive(),
                    cVRepositoryModel.getCvStyle())
    ).build();}
}
