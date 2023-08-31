package com.application.springazuredocker.user.domain.aggregates;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;

public class UserNameValueObject {
    public String value;
    private String validNameRegexp = "/^[a-zA-Z]+$/";
    public UserNameValueObject(String value) throws InvalidArgumentException {
        this.value = value;
        this.ensureValueIsDefined(value);
        this.ensureIsValidName(value);
        this.ensureIsValidLength(value);
    }
    private void ensureValueIsDefined(String value) throws InvalidArgumentException {
        if(value != null && !value.isEmpty()) return;
        throw new InvalidArgumentException("Name must be defined");
    }
    private void ensureIsValidName(String value) throws InvalidArgumentException {
        if(!value.matches(validNameRegexp)) {
            throw new InvalidArgumentException(String.format("%s Value not is a name", value));
        }
    }
    private void ensureIsValidLength(String value) throws InvalidArgumentException {
        if(value.length() < 3 || value.length() > 20) {
            throw new InvalidArgumentException(String.format("%s Value not is a valid length", value));
        }
    }
}
