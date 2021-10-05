package com.jplan.authorizationserver.exceptions;

import lombok.AllArgsConstructor;

/* For testing exception */
@AllArgsConstructor
public class MemberException extends RuntimeException {

    private Integer code;
    private String msg;

    public MemberException(Exception loginException) {
        super(loginException);
    }
}