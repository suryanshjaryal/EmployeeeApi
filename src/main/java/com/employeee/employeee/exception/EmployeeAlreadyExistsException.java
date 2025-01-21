package com.employeee.employeee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmployeeAlreadyExistsException extends RuntimeException {


    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}