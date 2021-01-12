package com.griddynamics.gridu.springta.phonebook.customer.exception;

import com.griddynamics.gridu.springta.phonebook.exception.ResourceNotFoundException;

public class CustomerNotFoundException extends ResourceNotFoundException {

    public CustomerNotFoundException(String message) {
        super(message);
    }

}
