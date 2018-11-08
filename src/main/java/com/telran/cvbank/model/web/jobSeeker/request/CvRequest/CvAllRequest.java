package com.telran.cvbank.model.web.jobSeeker.request.CvRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CvAllRequest {
    private Integer cvId;
    private String cvName;
    private Integer viewCount;
}

