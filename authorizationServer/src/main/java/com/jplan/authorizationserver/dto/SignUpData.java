package com.jplan.authorizationserver.dto;


import lombok.Getter;

@Getter
public class SignUpData {
    private String id;
    private String password;
    private String name;
    private String email;
}
