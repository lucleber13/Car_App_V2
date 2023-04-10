package com.cbcode.car_app_v2.Exceptions;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String message) {
        super(message);
    }
}
