package com.telran.cvbank.model.repositoryModel.cvRepositoryModel;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CVAllRepositoryModel {
    private Integer cvId;
    private String cvName;
    private Integer viewCount;
}
