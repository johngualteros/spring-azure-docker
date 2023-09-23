package com.application.springazuredocker.comment.domain.aggregates;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;

import java.util.Date;

public class CommentDateValueObject {
    public Date value;
    private String validDateRegexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
    public CommentDateValueObject(String value) throws InvalidArgumentException {
        this.ensureValueIsDefined(value);
        this.ensureIsValidDate(value);
        this.value = new Date(value);
    }
    private void ensureValueIsDefined(String value) throws InvalidArgumentException {
        if(value != null && !value.isEmpty()) return;
        throw new InvalidArgumentException("Value must be defined");
    }
    private void ensureIsValidDate(String value) throws InvalidArgumentException {
        if(!value.matches(validDateRegexp)) {
            throw new InvalidArgumentException("Date should be in format yyyy-mm-dd");
        }
    }
}
