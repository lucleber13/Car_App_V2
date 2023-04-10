package com.cbcode.car_app_v2.Exceptions;

public class CarAlreadyExistsException extends RuntimeException {
    public CarAlreadyExistsException(String message) {
        super(message);
    }
}
