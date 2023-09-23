package com.application.springazuredocker.user.domain.aggregates;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;

public class UserPassword {
    public String value;
    private String validPasswordRegexp = "/^(?=.*[a-z])(?=.*[A-Z])(?=.*d)[a-zA-Zd]{8,}$/i";
    public UserPassword(String value) throws InvalidArgumentException {
        this.value = value;
        this.ensureValueIsDefined(value);
        this.ensureIsValidPassword(value);
    }
    private void ensureValueIsDefined(String value) throws InvalidArgumentException {
        if(value != null && !value.isEmpty()) return;
        throw new InvalidArgumentException("Value must be defined");
    }
    private void ensureIsValidPassword(String value) throws InvalidArgumentException {
        if(!value.matches(validPasswordRegexp)) {
            throw new InvalidArgumentException(String.format("%s Value not is a password", value));
        }
    }
}
