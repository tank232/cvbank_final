package com.telran.cvbank.model.mongoModel;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "UserSessionMongoModel")
public class UserSessionMongoModel {
    @Id
    private String email;
    private List<String> roles;
    private String remoteAddr;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private Boolean valid;
    private String token;
    private String password;
}
