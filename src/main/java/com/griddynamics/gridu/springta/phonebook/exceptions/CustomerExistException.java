package com.griddynamics.gridu.springta.phonebook.exceptions;

public class CustomerExistException extends ResourceExistException {

    public CustomerExistException(String message) {
        super(message);
    }

}
