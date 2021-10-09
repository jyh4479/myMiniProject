package com.jplan.authorizationserver.exceptions;

//https://luvstudy.tistory.com/50 --> 에러 처리 참고
/* For testing exception */
public class MemberException extends RuntimeException {

    private Integer errorCode;
    private String errorMessage;

    public MemberException() {
        super();
    }

    public MemberException(String errorMessage) {
        super(errorMessage);
    }

    public MemberException(Integer errorCode) {
        super("ErrorCode is [" + Integer.toString(errorCode) + "]");
    }

    public MemberException(Throwable memberException) {
        super(memberException);
    }

    public MemberException(Integer errorCode, String errorMessage, Throwable memberException) {
        super("[");
    }
}