package com.huberthvladimir.urlshortening.exception;

public class InexistentUrlException extends RuntimeException {
    
    public InexistentUrlException() {
        super("Url not found");
    }

    public InexistentUrlException(String message) {
        super(message);
    }
}
