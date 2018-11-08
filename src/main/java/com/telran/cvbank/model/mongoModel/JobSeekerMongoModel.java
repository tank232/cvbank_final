package com.telran.cvbank.model.mongoModel;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "job_seeker")
public class JobSeekerMongoModel {
    private String firstName;
    private String lastName;
    private String password;
    @Id
    private String email;
    @Indexed(unique = true)
    private String phone;
   /* @DateTimeFormat(style = "M-")
    @CreatedDate
    private Date auditDate;
    @DateTimeFormat(style = "M-")
    @LastModifiedBy
    private Date auditCDate;*/
}
