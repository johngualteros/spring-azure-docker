package com.application.springazuredocker.tag.domain.aggregates;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;

public class TagNameValueObject {
    public String value;
    private String validNameRegexp = "[a-zA-Z]+";
    public TagNameValueObject(String value) throws InvalidArgumentException {
        this.value = value;
        this.ensureValueIsDefined(value);
        this.ensureIsValidName(value);
    }
    private void ensureValueIsDefined(String value) throws InvalidArgumentException {
        if(value != null && !value.isEmpty()) return;
        throw new InvalidArgumentException("Value must be defined");
    }
    private void ensureIsValidName(String value) throws InvalidArgumentException {
        if(!value.matches(validNameRegexp)) {
            throw new InvalidArgumentException("Name should contains only letters");
        }
    }
}
