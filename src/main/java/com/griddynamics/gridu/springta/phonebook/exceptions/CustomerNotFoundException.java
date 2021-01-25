package com.griddynamics.gridu.springta.phonebook.exceptions;

public class CustomerNotFoundException extends ResourceNotFoundException {

    public CustomerNotFoundException(String message) {
        super(message);
    }

}
