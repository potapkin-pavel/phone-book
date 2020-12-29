package pl.krakow.phonebook.customer.exception;

import pl.krakow.phonebook.exception.ResourceNotFoundException;

public class CustomerNotFoundException extends ResourceNotFoundException {

    public CustomerNotFoundException(String message) {
        super(message);
    }

}
