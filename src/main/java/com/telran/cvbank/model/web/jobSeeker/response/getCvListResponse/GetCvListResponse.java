package com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetCvListResponse {
    private Integer currentPage;
    private Integer itemsOnPage;
    private Integer itemsTotal;
    private List<CvListResponse> cvList;
}
