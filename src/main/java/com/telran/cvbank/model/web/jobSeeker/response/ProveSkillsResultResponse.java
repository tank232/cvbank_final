package com.telran.cvbank.model.web.jobSeeker.response;

import com.telran.cvbank.model.web.jobSeeker.response.getCvListResponse.CVskills;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProveSkillsResultResponse {
    private List<CVskills> skills;
}
