package com.huberthvladimir.urlshortening.exception;

public class InvalidValueException extends RuntimeException {

    public InvalidValueException() {
        super("Invalid data type for field 'url'. Expected string.");
    }

    public InvalidValueException(String message) {
        super(message);
    }
}
