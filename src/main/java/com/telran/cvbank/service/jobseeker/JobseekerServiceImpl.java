package com.telran.cvbank.service.jobseeker;

import com.fasterxml.uuid.Generators;
import com.telran.cvbank.model.web.jobSeeker.response.JobSeekerResponse;
import com.telran.cvbank.model.repositoryModel.JobSeekerRepositoryModel;
import com.telran.cvbank.model.web.jobSeeker.request.JobSeekerRegistrationRequest;
import com.telran.cvbank.model.web.jobSeeker.response.JobSeekerInnerResponse;
import com.telran.cvbank.model.web.jobSeeker.response.getCatalogsResponse.Catalogs;
import com.telran.cvbank.model.web.jobSeeker.response.getCatalogsResponse.GetCatalogsResponse;
import com.telran.cvbank.repository.jobseeker.JobseekerRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JobseekerServiceImpl implements JobseekerService {

    @Autowired
    private JobseekerRepository jobseekerRepository;


    private String getTokenDecode(String token)
    {
        if (token == null) {
            throw new UsernameNotFoundException("Unauthorized");
        }
        String tokenDecode =token;//new  String(Base64.decodeBase64(token.getBytes()));

        if(tokenDecode.split(":")[0]==null || tokenDecode.split(":")[1]==null)
        {throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Wrong token");}
       return tokenDecode;

    }

    @Override
    public JobSeekerResponse registration(JobSeekerRegistrationRequest jobSeekerRegistrationRequest, String authorization,String remoteAddr)
    {
        String email=getTokenDecode(authorization).split(":")[0];
        String password=getTokenDecode(authorization).split(":")[1];
        JobSeekerRepositoryModel jobSeekerRepositoryModel = JobSeekerRepositoryModel.builder()
                .firstName(jobSeekerRegistrationRequest.getFirstName())
                .lastName(jobSeekerRegistrationRequest.getLastName())
                .email(jobSeekerRegistrationRequest.getEmail())
                .phone(jobSeekerRegistrationRequest.getPhone()).password(password).token(UUID.randomUUID().toString()//Generators.timeBasedGenerator().generate().toString()//
                ).remoteAddr(remoteAddr)
                .build();
        System.out.print(jobSeekerRepositoryModel.getToken());
        jobseekerRepository.createJobseeker(jobSeekerRepositoryModel);
        JobSeekerInnerResponse jobSeekerInnerResponse=JobSeekerInnerResponse.builder()
                .firstName(jobSeekerRegistrationRequest.getFirstName())
                .lastName(jobSeekerRegistrationRequest.getLastName())
                .email(jobSeekerRegistrationRequest.getEmail())
                .phone(jobSeekerRegistrationRequest.getPhone()).build();

        return JobSeekerResponse.builder().jobSeekerInnerResponse(jobSeekerInnerResponse).token(jobSeekerRepositoryModel.getToken()).build();
    }

    @Override
    public JobSeekerResponse authorization( String authorization,String remoteAddr) {
        String email=getTokenDecode(authorization).split(":")[0];
        String password=getTokenDecode(authorization).split(":")[1];
        JobSeekerRepositoryModel jobSeekerRepositoryModel =jobseekerRepository.getJobSeekerRepositoryModel(email);

        if (jobSeekerRepositoryModel == null) {
            throw new UsernameNotFoundException("Unauthorized");
        }
        if (!jobSeekerRepositoryModel.getPassword().equals(password)) {
            throw new UsernameNotFoundException("Unauthorized");
        }
        jobseekerRepository.setValidSession(email,true);
        jobseekerRepository.setRemoteAddr(email,remoteAddr);
        JobSeekerInnerResponse jobSeekerInnerResponse=JobSeekerInnerResponse.builder()
                .firstName(jobSeekerRepositoryModel.getFirstName())
                .lastName(jobSeekerRepositoryModel.getLastName())
                .email(jobSeekerRepositoryModel.getEmail())
                .phone(jobSeekerRepositoryModel.getPhone()).build();

        return JobSeekerResponse.builder().jobSeekerInnerResponse(jobSeekerInnerResponse).token(jobSeekerRepositoryModel.getToken()).build();

    }


    @Override
    public void unauthorization(String email) {
        jobseekerRepository.setValidSession(email,false);
    }



    @Override
    public GetCatalogsResponse getCatalogs(String email) {
        return  GetCatalogsResponse.builder().catalogs(
                jobseekerRepository.getDict().stream().
                        map(x->new Catalogs(x.getNameDictionary(),
                                x.getListValues().stream().collect(Collectors.toList()))).
                        collect(Collectors.toList())

        ).build();
    }

}