package com.huberthvladimir.urlshortening.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.huberthvladimir.urlshortening.dto.StandardErrorDto;
import com.huberthvladimir.urlshortening.exception.InexistentUrlException;
import com.huberthvladimir.urlshortening.exception.InvalidValueException;

@ControllerAdvice
public class InvalidValueExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidValueException.class)
    private ResponseEntity<StandardErrorDto> InvalidValueHandler(InvalidValueException exception) {
        StandardErrorDto threatResponse = new StandardErrorDto(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);

    }

    @ExceptionHandler(InexistentUrlException.class)
    private ResponseEntity<StandardErrorDto> InexistentUrlHandler(InexistentUrlException exception) {
        StandardErrorDto threatResponse = new StandardErrorDto(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);

    }
}
