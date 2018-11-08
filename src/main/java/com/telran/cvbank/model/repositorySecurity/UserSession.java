package com.telran.cvbank.model.repositorySecurity;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserSession {
    private String sessionId;

    private List<String> roles;
    private Boolean isValid;
    private String login;
    private String password;
}
