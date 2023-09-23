package com.application.springazuredocker.user.domain.aggregates;

import com.application.springazuredocker.shared.domain.exceptions.InvalidArgumentException;

public class UserEmailValueObject {
    public String value;
    private String validEmailRegexp = "/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$/i";
    public UserEmailValueObject(String value) throws InvalidArgumentException {
        this.value = value;
        this.ensureValueIsDefined(value);
        this.ensureIsValidEmail(value);
    }
    private void ensureValueIsDefined(String value) throws InvalidArgumentException {
        if(value != null && !value.isEmpty()) return;
        throw new InvalidArgumentException("Value must be defined");
    }
    private void ensureIsValidEmail(String value) throws InvalidArgumentException {
        if(!value.matches(validEmailRegexp)) {
            throw new InvalidArgumentException(String.format("%s Value not is a email", value));
        }
    }
}
