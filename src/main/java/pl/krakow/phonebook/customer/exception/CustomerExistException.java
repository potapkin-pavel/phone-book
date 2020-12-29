package pl.krakow.phonebook.customer.exception;

import pl.krakow.phonebook.exception.ResourceExistException;

public class CustomerExistException extends ResourceExistException {

    public CustomerExistException(String message) {
        super(message);
    }

}
