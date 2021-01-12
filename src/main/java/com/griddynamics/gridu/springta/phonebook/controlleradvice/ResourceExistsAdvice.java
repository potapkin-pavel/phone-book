package com.griddynamics.gridu.springta.phonebook.controlleradvice;

import com.griddynamics.gridu.springta.phonebook.exception.ResourceExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ResourceExistsAdvice {

    @ResponseBody
    @ExceptionHandler(ResourceExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String resourceNotFoundHandler(ResourceExistException ex) {
        return String.format("resource already exists '%s'", ex.getMessage());
    }

}
