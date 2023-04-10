package com.cbcode.car_app_v2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionsHandlerCarApp {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions (
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CarAlreadyExistsException.class)
    public Map<String, String> carAlreadyExistsException(
            CarAlreadyExistsException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CarNotFoundException.class)
    public Map<String, String> carNotFoundException(
            CarNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyExistsException.class)
    public Map<String, String> userAlreadyExistsException(
            UserAlreadyExistsException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> userNotFoundException(
            UserNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public Map<String, String> customerNotFoundException(
            CustomerNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValetNotSavedException.class)
    public Map<String, String> valetNotSavedException(
            ValetNotSavedException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ValetNotFoundException.class)
    public Map<String, String> valetNotFoundException(
            ValetNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return errors;
    }

}
