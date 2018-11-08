package com.telran.cvbank.model.web.jobSeeker.request;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JobSeekerRegistrationRequest {

        @NotBlank(message = "password name cannot be firstName")
        @Length(
                min = 3,
                max = 20,
                message = "Length password must be between 3 and 20")
        private String firstName;
        @NotBlank(message = "password name cannot be lastName")
        @Length(
                min = 3,
                max = 20,
                message = "Length password must be between 3 and 20")
        private String lastName;
        @Email(message = "Email incorrect")
        private String email;
        @NotBlank(message = "password name cannot be phone")
        private String phone;

}
