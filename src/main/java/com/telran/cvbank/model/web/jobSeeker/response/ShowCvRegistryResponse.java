package com.telran.cvbank.model.web.jobSeeker.response;

import com.telran.cvbank.model.web.jobSeeker.request.CvRequest.CvAllRequest;
import com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse.CV;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShowCvRegistryResponse {
    private List<CvAllRequest> cvList;
}
