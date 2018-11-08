package com.telran.cvbank.model.web.jobSeeker.response.getCatalogsResponse;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Catalogs {
    private String catalogName;
    private List<String> catalogBody;
}
