package com.telran.cvbank.model.web.jobSeeker.response;


import com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse.CV;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CvResponse {
    private CV cv;
}
