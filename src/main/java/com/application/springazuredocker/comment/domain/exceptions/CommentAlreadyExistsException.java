package com.application.springazuredocker.comment.domain.exceptions;

public class CommentAlreadyExistsException extends Exception{
    public CommentAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }

}
