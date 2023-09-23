package com.application.springazuredocker.tag.domain.exceptions;

public class TagNotFoundException extends Exception{
    public TagNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
