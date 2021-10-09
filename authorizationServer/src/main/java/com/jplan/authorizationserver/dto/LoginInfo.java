package com.jplan.authorizationserver.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginInfo {
    private String id;
    private String password;
}
