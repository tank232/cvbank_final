package com.telran.cvbank.model.web.jobSeeker.response.getCatalogsResponse;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetCatalogsResponse {
    private List<Catalogs> catalogs;
}
