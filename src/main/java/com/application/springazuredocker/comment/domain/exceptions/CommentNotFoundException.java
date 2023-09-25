package com.application.springazuredocker.comment.domain.exceptions;

public class CommentNotFoundException extends Exception{
    public CommentNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
