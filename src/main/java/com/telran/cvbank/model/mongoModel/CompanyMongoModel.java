package com.telran.cvbank.model.mongoModel;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "user")
public class CompanyMongoModel {
    private String companyName;
    private String webSite;
    private String country;
    private String cityTown;
    private String street;
    private String houseBuilding;
    private String aplicantFirstName;
    private String aplicantLastName;
    private String aplicantPosition;
    private String aplicantEmail;
    private String aplicantPhone;
}
