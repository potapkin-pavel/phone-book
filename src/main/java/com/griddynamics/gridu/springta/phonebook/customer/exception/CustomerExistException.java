package com.griddynamics.gridu.springta.phonebook.customer.exception;

import com.griddynamics.gridu.springta.phonebook.exception.ResourceExistException;

public class CustomerExistException extends ResourceExistException {

    public CustomerExistException(String message) {
        super(message);
    }

}
