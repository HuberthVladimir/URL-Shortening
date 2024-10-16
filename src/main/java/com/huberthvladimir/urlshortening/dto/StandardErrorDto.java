package com.huberthvladimir.urlshortening.dto;

import org.springframework.http.HttpStatus;

public class StandardErrorDto {
    private String messageError;
    private HttpStatus responseStatus;

    public StandardErrorDto(String messageError, HttpStatus responseStatus) {
        this.messageError = messageError;
        this.responseStatus = responseStatus;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
