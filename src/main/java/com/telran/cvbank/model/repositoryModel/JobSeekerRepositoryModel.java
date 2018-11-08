package com.telran.cvbank.model.repositoryModel;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class JobSeekerRepositoryModel  {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String token;
    String remoteAddr;
}