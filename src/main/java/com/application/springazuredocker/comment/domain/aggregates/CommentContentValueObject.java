package com.application.springazuredocker.comment.domain.aggregates;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;

public class CommentContentValueObject {
    public String value;
    public CommentContentValueObject(String value) throws InvalidArgumentException {
        this.ensureValueIsDefined(value);
        this.value = value;
    }
    private void ensureValueIsDefined(String value) throws InvalidArgumentException {
        if(value != null && !value.isEmpty()) return;
        throw new InvalidArgumentException("Value must be defined");
    }
}
