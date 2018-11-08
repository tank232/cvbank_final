package com.telran.cvbank.model.repositoryModel;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DictModel {
    private String nameDictionary;
    private Set<String> listValues;
}
