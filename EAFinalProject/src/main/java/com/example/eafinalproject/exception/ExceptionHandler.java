package com.example.eafinalproject.exception;

public class ExceptionHandler {

    public static void handleException(String message) {
        throw new ResourceNotFoundException(message);
    }
}
