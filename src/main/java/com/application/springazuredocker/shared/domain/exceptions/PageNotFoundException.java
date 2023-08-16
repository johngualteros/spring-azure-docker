package com.application.springazuredocker.shared.domain.exceptions;

public class PageNotFoundException extends Exception {
    public PageNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
