package com.telran.cvbank.controller.jobSeekerController;

import com.telran.cvbank.exception.InputValidationException;
import com.telran.cvbank.model.repositorySecurity.UserSession;
import com.telran.cvbank.model.web.jobSeeker.request.CvRequest.CvRequest;
import com.telran.cvbank.model.web.jobSeeker.request.EditJobSeekerProfileRequest;
import com.telran.cvbank.model.web.jobSeeker.request.JobSeekerRegistrationRequest;
import com.telran.cvbank.model.web.jobSeeker.response.*;
import com.telran.cvbank.model.web.jobSeeker.response.getCatalogsResponse.GetCatalogsResponse;
import com.telran.cvbank.model.web.jobSeeker.response.jobSeekerLoginResponse.JobSeekerLoginProfile;
import com.telran.cvbank.service.jobseeker.JobseekerService;
import com.telran.cvbank.service.jobseekerCv.JobseekerCvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/jobSeeker")
public class JobseekerController {

    @Autowired
    private JobseekerService jobseekerService;
    @Autowired
    private JobseekerCvService jobseekerCvService;

    //POST Registration Job Seeker /jobSeeker/registration
    @PostMapping("/registration")
    public JobSeekerResponse registration
    (@RequestBody JobSeekerRegistrationRequest jobSeekerRegistrationRequest, BindingResult result, @RequestHeader(value="Authorization") String authorization, HttpServletRequest request){
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        return jobseekerService.registration(jobSeekerRegistrationRequest,authorization,request.getRemoteAddr());
    }

    //GET login job seeker /jobSeeker/login
    @GetMapping("/login")
    public JobSeekerResponse login(@RequestHeader(value="Authorization") String authorization , HttpServletRequest request)
    {
        return  jobseekerService.authorization(authorization,request.getRemoteAddr());
    }

    //GET show cv registry  /jobSeeker/profile
    @GetMapping("/profile")
    public ShowCvRegistryResponse showCvRegistry(UserSession userSession){
        ShowCvRegistryResponse showCvRegistryResponse=jobseekerCvService.ShowCvRegistryResponse(userSession.getLogin());
        return showCvRegistryResponse;
    }

    //GET get catalogs /jobSeeker/catalogs
    @GetMapping("/catalogs")
    public GetCatalogsResponse getCatalogs(UserSession userSession){
        return jobseekerService.getCatalogs(userSession.getLogin());
    }

    //GET get CV List /jobSeeker/cvList?itemsOnPage=<Integer>&currentPage=<Integer>
    @GetMapping("/cvList{itemsOnPage}{currentPage}")
    public void getCvList(@RequestHeader String token, @Param("itemsOnPage") Integer itemsOnPage, @Param("currentPage") Integer currentPage){

    }

    //GET Get CV /jobSeeker/cv?cvId=<String>
    @GetMapping("cv{cvId}")
    public GetCvResponse getCv(@RequestHeader String token, @Param("cvId") String cvId){
        return null;
    }

    //PUT Save CV  /jobSeeker/cv
    @PostMapping("/cv")
    public CvResponse saveCv(@RequestHeader String token, @RequestBody CvRequest cvRequest, BindingResult result){
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        return jobseekerCvService.save(cvRequest);
    }

    //DELETE Remove CV /jobSeeker/cv?cvId=<String>
    @DeleteMapping("/cv{cvId}")
    public CvResponse removeCv(@RequestHeader String token, @Param("cvId") String cvId)
    {
        return jobseekerCvService.delete(cvId);
    }
    //PUT enable CV /jobSeeker/cvVisible?cvId=<String>&isVisible=<Boolean>
    @PutMapping("/cvVisible{cvId}{isVisible}")
    public void cvVisible(@RequestHeader String token, @Param("cvId") String cvId, @Param("isVisible") Boolean isVisible){

    }

    //PUT edit job seeker profile /jobSeeker/profile
    @PutMapping("/profile")
    public JobSeekerLoginProfile profile(@RequestHeader String token, @RequestBody EditJobSeekerProfileRequest editJobSeekerProfileRequest){
        return null;
    }

    //GET prove skills result /jobSeeker/proveSkillsResult
    @GetMapping("/proveSkillsResult")
    public ProveSkillsResultResponse proveSkillsResult(@RequestHeader String token){
        return null;
    }

    //PUT prove skill /jobSeeker/proveSkill?skillName=<String>
    @PutMapping("/proveSkill{skillName}")
    public void proveSkill(@RequestHeader String token, @Param("skillName") String skillName){

    }

    //GET prove CV results /jobSeeker/proveCVResult
    @GetMapping("/proveCVResult")
    public void proveCVResult(@RequestHeader String token){

    }
}
