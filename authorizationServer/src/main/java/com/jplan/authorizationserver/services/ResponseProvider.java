package com.jplan.authorizationserver.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseProvider {
    public ResponseEntity<?> successMessage(Object data, HttpHeaders headers){
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

    public ResponseEntity<?> successMessage(Object data){
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    public ResponseEntity<?> successMessage(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> notFoundMessage(Object data){
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
