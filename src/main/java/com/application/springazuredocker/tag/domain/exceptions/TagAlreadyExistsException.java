package com.application.springazuredocker.tag.domain.exceptions;

public class TagAlreadyExistsException extends Exception{
    public TagAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }

}
