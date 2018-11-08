package com.telran.cvbank.model.web.jobSeeker.response.jobSeekerLoginResponse;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JobSeekerLoginProfile {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
