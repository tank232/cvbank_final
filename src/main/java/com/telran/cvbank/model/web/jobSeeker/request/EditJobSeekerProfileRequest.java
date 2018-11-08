package com.telran.cvbank.model.web.jobSeeker.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EditJobSeekerProfileRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
