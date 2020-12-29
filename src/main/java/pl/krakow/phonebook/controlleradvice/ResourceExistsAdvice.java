package pl.krakow.phonebook.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.krakow.phonebook.exception.ResourceExistException;

@ControllerAdvice
public class ResourceExistsAdvice {

    @ResponseBody
    @ExceptionHandler(ResourceExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String resourceNotFoundHandler(ResourceExistException ex) {
        return String.format("resource already exists '%s'", ex.getMessage());
    }

}
