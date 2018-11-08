package com.telran.cvbank.model.mongoModel;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "dictionary")
public class DictMongoModel {
    @JsonProperty("_id")
    private String nameDictionary;
    private Set<String> listValues;
}
