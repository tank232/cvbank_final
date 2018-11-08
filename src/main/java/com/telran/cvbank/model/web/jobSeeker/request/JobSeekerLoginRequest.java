package com.telran.cvbank.model.web.jobSeeker.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JobSeekerLoginRequest {
    private String login;
    private String password;
}
