package com.telran.cvbank.repository.jobseekerCv;

import com.telran.cvbank.model.mongoModel.JobSeekerCvMongoModel;
import com.telran.cvbank.model.mongoModel.JobSeekerSvSet.EducationRepositoryModel;
import com.telran.cvbank.model.mongoModel.JobSeekerSvSet.ExperienceRepositoryModel;
import com.telran.cvbank.model.mongoModel.JobSeekerSvSet.ProjectJobRepositoryModel;
import com.telran.cvbank.model.mongoModel.JobSeekerSvSet.SkillRepositoryModel;
import com.telran.cvbank.model.repositoryModel.cvRepositoryModel.*;
import com.telran.cvbank.repository.mongoRepository.JobSeekerCvMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class JobseekerCvRepositoryImpl implements JobseekerCvRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    private Query query;
    @Autowired
    private JobSeekerCvMongoRepository jobSeekerCvMongoRepository;

    public List<CVAllRepositoryModel> getCVAllbyEmail(String email)
    {
      AggregationOperation match = Aggregation.match(where("email").is(email));
        AggregationOperation group = Aggregation.group("cvId","cvName","viewCount","email");
        AggregationOperation sort = Aggregation.sort(Sort.Direction.DESC, "cvId");
        Aggregation aggregation = Aggregation.newAggregation(match,group,sort);
        AggregationResults<CVAllRepositoryModel> groupResults
                = mongoTemplate.aggregate( aggregation, JobSeekerCvMongoModel.class, CVAllRepositoryModel.class);
        return groupResults.getMappedResults();

       }

    @Override
    public void save(CVRepositoryModel cvRepositoryModel) {
        jobSeekerCvMongoRepository.save(getJobSeekerCvMongoModel(cvRepositoryModel));
    }

    @Override
    public void delete(CVRepositoryModel cVRepositoryModel) {
        jobSeekerCvMongoRepository.delete(getJobSeekerCvMongoModel(cVRepositoryModel));
    }

    @Override
    public CVRepositoryModel getCVById(String cvId) {
        JobSeekerCvMongoModel jobSeekerCvMongoModel=jobSeekerCvMongoRepository.findById(cvId).get();
        return new CVRepositoryModel(
                 jobSeekerCvMongoModel.getCvId(),
                 jobSeekerCvMongoModel.getCvName(),
                 jobSeekerCvMongoModel.getViewCount(),
                jobSeekerCvMongoModel.getFirstName(),
        jobSeekerCvMongoModel.getIsFirstnameVisible(),
        jobSeekerCvMongoModel.getLastName(),
        jobSeekerCvMongoModel.getIsLastNameVisible(),
        jobSeekerCvMongoModel.getIsTitleVisible(),
        jobSeekerCvMongoModel.getExperiences().stream()
                        .map(x->new ExperienceRepositoryModel(x.getPosition(),x.getYears())).collect(Collectors.toList()),
                jobSeekerCvMongoModel.getTotalExperience(),
                jobSeekerCvMongoModel.getResidence(),
                jobSeekerCvMongoModel.getIsResidenceVisible(),
                jobSeekerCvMongoModel.getBirthday(),
                jobSeekerCvMongoModel.getIsBirthdayVisible(),
                jobSeekerCvMongoModel.getPhone(),
                jobSeekerCvMongoModel.getIsPhoneVisible(),
                jobSeekerCvMongoModel.getEmail(),
                jobSeekerCvMongoModel.getIsEmailVisible(),
        jobSeekerCvMongoModel.getLinkedIn(),
        jobSeekerCvMongoModel.getIsLinkedInVisible(),
        jobSeekerCvMongoModel.getIsContactInfoVisible(),
        jobSeekerCvMongoModel.getAbout(),
        jobSeekerCvMongoModel.getPreferableArea().stream().collect(Collectors.toList()),
        jobSeekerCvMongoModel.getPosition(),
        jobSeekerCvMongoModel.getSalaryFrom(),
        jobSeekerCvMongoModel.getSalaryTo(),
        jobSeekerCvMongoModel.getEducations().stream().map(x->new EducationRepositoryModel(
                        x.getSchoolInstitutionName(),
                        x.getDegree()
                        ,x.getGraduationYear()
                        ,x.getLocation()
                        ,x.getDetails()
                        ,x.getIsEducationVisible())).collect(Collectors.toSet()),
                jobSeekerCvMongoModel.getSkills().stream()
                        .map(x->new SkillRepositoryModel(x.getSkill(),x.getIsProved())).collect(Collectors.toSet()),
                jobSeekerCvMongoModel.getProjectJobs().stream().map(x->new ProjectJobRepositoryModel(x.getCompany()
                        ,x.isCompanyVisible()
                        ,x.getPosition()
                        ,x.getBackEndFrontEndRatio()
                        ,x.getStartDate()
                        ,x.getEndDate()
                        ,x.getProjectDescription())).collect(Collectors.toSet()),
        jobSeekerCvMongoModel.getAchivements().stream().collect(Collectors.toSet()),
        jobSeekerCvMongoModel.getCertifications().stream().collect(Collectors.toSet()),
        jobSeekerCvMongoModel.getLanguages().stream().collect(Collectors.toSet()),
        jobSeekerCvMongoModel.getFooterLinks().stream().collect(Collectors.toSet()),
        jobSeekerCvMongoModel.getIsFooterLinkVisible(),
        jobSeekerCvMongoModel.getFooterInfo().stream().collect(Collectors.toList()),
        jobSeekerCvMongoModel.getIsFooterInfoVisible(),
        jobSeekerCvMongoModel.getIsActive(),
        jobSeekerCvMongoModel.getCvStyle());
    }

    private JobSeekerCvMongoModel getJobSeekerCvMongoModel(CVRepositoryModel cvRepositoryModel)
    {return JobSeekerCvMongoModel
            .builder()
            .cvId(cvRepositoryModel.getCvId())
            .cvName(cvRepositoryModel.getCvName())
            .viewCount(0)
            .firstName(cvRepositoryModel.getFirstname())
            .isFirstnameVisible(cvRepositoryModel.getIsFirstnameVisible())
            .lastName(cvRepositoryModel.getLastName())
            .isLastNameVisible(cvRepositoryModel.getIsLastNameVisible())
            .isTitleVisible(cvRepositoryModel.getIsTitleVisible())
            .experiences(cvRepositoryModel.getLocalExperience().stream()
                    .map(x->new ExperienceRepositoryModel(x.getPosition(),x.getYears())).collect(Collectors.toSet()))
            .totalExperience(cvRepositoryModel.getTotalExperience())
            .residence(cvRepositoryModel.getResidence())
            .isResidenceVisible(cvRepositoryModel.getIsResidenceVisible())
            .birthday(cvRepositoryModel.getBirthday())
            .isBirthdayVisible(cvRepositoryModel.getIsBirthdayVisible())
            .phone(cvRepositoryModel.getPhone())
            .isPhoneVisible(cvRepositoryModel.getIsPhoneVisible())
            .email(cvRepositoryModel.getEmail())
            .isEmailVisible(cvRepositoryModel.getIsEmailVisible())
            .linkedIn(cvRepositoryModel.getLinkedIn())
            .isLinkedInVisible(cvRepositoryModel.getIsLinkedInVisible())
            .isContactInfoVisible(cvRepositoryModel.getIsContactInfoVisible())
            .about(cvRepositoryModel.getAbout())
            .preferableArea(cvRepositoryModel.getPreferableArea().stream().collect(Collectors.toSet()))
            .position(cvRepositoryModel.getPosition())
            .salaryFrom(cvRepositoryModel.getSalaryFrom())
            .salaryTo(cvRepositoryModel.getSalaryTo())
            .educations(cvRepositoryModel.getEducation().stream().map(x->new EducationRepositoryModel(
                    x.getSchoolInstitutionName(),
                    x.getDegree()
                    ,x.getGraduationYear()
                    ,x.getLocation()
                    ,x.getDetails()
                    ,x.getIsEducationVisible())).collect(Collectors.toSet()))
            .skills(cvRepositoryModel.getSkills().stream()
                    .map(x->new SkillRepositoryModel(x.getSkillName(),x.getIsProved())).collect(Collectors.toSet()))
            .projectJobs(cvRepositoryModel.getProjectJobs().stream().map(x->new ProjectJobRepositoryModel(x.getCompany()
                    ,x.getIsCompanyVisible()
                    ,x.getPosition()
                    ,x.getBackEndFrontEndRatio()
                    ,x.getStartDate()
                    ,x.getEndDate()
                    ,x.getProjectDescription())).collect(Collectors.toSet()))
            .achivements(cvRepositoryModel.getAchivements().stream().collect(Collectors.toSet()))
            .certifications(cvRepositoryModel.getCertifications().stream().collect(Collectors.toSet()))
            .languages(cvRepositoryModel.getLanguages().stream().collect(Collectors.toSet()))
            .footerLinks(cvRepositoryModel.getFooterLinks().stream().collect(Collectors.toSet()))
            .isFooterLinkVisible(cvRepositoryModel.getIsFooterLinkVisible())
            .footerInfo(cvRepositoryModel.getFooterInfo().stream().collect(Collectors.toSet()))
            .isFooterInfoVisible(cvRepositoryModel.getIsFooterInfoVisible())
            .isActive(cvRepositoryModel.getIsActive())
            . cvStyle(cvRepositoryModel.getCvStyle()).build();
    }
}
